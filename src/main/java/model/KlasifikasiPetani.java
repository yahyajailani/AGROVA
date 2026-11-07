package model;

import java.math.BigDecimal;

//Penentuan golongan petani berdasarkan luas lahan
public class KlasifikasiPetani {

    public static final String GOL_A = "Gol A";
    public static final String GOL_B = "Gol B";
    public static final String GOL_C = "Gol C";

    public static String tentukanGolongan(BigDecimal luasLahan) {

        if (luasLahan == null || luasLahan.signum() <= 0) {
            throw new IllegalArgumentException(
                "Luas lahan harus lebih dari 0."
            );
        }

        if (luasLahan.compareTo(new BigDecimal("2")) > 0) {
            return GOL_A;
        }

        if (luasLahan.compareTo(new BigDecimal("1")) >= 0) {
            return GOL_B;
        }

        return GOL_C;
    }

    /** Golongan A (lahan lebih dari 2 ha) = tidak berhak menerima pupuk subsidi
        Golongan B dan C (luas lahan di bawah 2 ha) = berhak menerima pupuk subsidi*/
    
    public static boolean berhakSubsidi(BigDecimal luasLahan) {
        return !GOL_A.equals(tentukanGolongan(luasLahan));
    }
}
