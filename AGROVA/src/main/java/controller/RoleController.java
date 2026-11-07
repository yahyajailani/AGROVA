package controller;

import model.User;
import model.dao.LaporanDao;

import java.sql.SQLException;

//Abstrak controller tiap user
public abstract class RoleController implements Kelola {
    protected final User user;
    protected final LaporanDao laporan = new LaporanDao();

    protected RoleController(User user) {
        this.user = user;
    }

    //Menjalankan menu user sesuai pilihan
    @Override
    public abstract void jalankan() throws SQLException;
}

