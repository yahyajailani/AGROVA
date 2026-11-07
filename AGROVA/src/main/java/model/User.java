package model;

import java.util.LinkedHashMap;
import java.util.Map;

//Superclass abstract user
public abstract class User {
    private int id;
    private String nama;
    private String email;
    private String noHp;

    protected User(int id, String nama, String email, String noHp) {
        this.id = id;
        setNama(nama);
        setEmail(email);
        setNoHp(noHp);
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }

    public final void setNama(String nama) {
        if (nama == null || nama.isBlank() || nama.length() > 150) {
            throw new BusinessException("Nama wajib diisi (maksimal 150 karakter).");
        }
        this.nama = nama.trim();
    }

    public String getEmail() { return email; }

    public final void setEmail(String email) {
        if (!Security.isEmail(email)) {
            throw new BusinessException("Format email tidak valid (maksimal 50 karakter).");
        }
        this.email = email;
    }

    public String getNoHp() { return noHp; }

    public final void setNoHp(String noHp) {
        if (!Security.isDigits(noHp, 9, 15)) {
            throw new BusinessException("No HP harus 9-15 digit angka.");
        }
        this.noHp = noHp;
    }

    //Method abstrak setiap subclass
    public abstract Role getPeran();

    //Mengumpulkan dan menyusun data profil milik user
    public Map<String, Object> getInfoProfil() {
        Map<String, Object> m = new LinkedHashMap<>();
        m.put("nama", nama);
        m.put("email", email);
        m.put("no_hp", noHp);
        m.put("peran", getPeran());
        return m;
    }

    @Override
    public String toString() {
        return getPeran() + " - " + nama + " <" + email + ">";
    }
}

