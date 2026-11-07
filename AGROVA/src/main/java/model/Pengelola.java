package model;

import java.util.Map;

//Data Pengelola
public class Pengelola extends User {
    private String jabatan;
    private String nip;

    public Pengelola(int id, String nama, String email, String noHp, String jabatan, String nip) {
        super(id, nama, email, noHp);
        this.jabatan = jabatan;
        this.nip = nip;
    }

    public String getJabatan() { return jabatan; }

    public void setJabatan(String jabatan) { this.jabatan = jabatan; }

    public String getNip() { return nip; }

    public void setNip(String nip) { this.nip = nip; }

    @Override
    public Role getPeran() {
        return Role.PENGELOLA;
    }

    @Override
    public Map<String, Object> getInfoProfil() {
        Map<String, Object> m = super.getInfoProfil();
        m.put("jabatan", jabatan);
        m.put("nip", nip);
        return m;
    }
}

