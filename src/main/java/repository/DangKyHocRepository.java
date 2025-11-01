package repository;


import entity.DangKyHoc;
import entity.SinhVien;
import jakarta.persistence.EntityManager;
import java.util.List;

public class DangKyHocRepository extends BaseRepository {

    public void save(DangKyHoc dk) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(dk);
        em.getTransaction().commit();
        em.close();
    }

    public List<DangKyHoc> findBySinhVien(SinhVien sv) {
        EntityManager em = getEntityManager();
        List<DangKyHoc> list = em.createQuery(
                        "FROM DangKyHoc d WHERE d.sinhVien.id = :id", DangKyHoc.class)
                .setParameter("id", sv.getId())
                .getResultList();
        em.close();
        return list;
    }

    public void delete(DangKyHoc dk) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        DangKyHoc toDelete = em.find(DangKyHoc.class, dk.getId());
        if (toDelete != null) {
            em.remove(toDelete);
        }
        em.getTransaction().commit();
        em.close();
    }
}