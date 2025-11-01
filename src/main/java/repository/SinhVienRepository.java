package repository;

import entity.SinhVien;
import jakarta.persistence.EntityManager;
import java.util.List;

public class SinhVienRepository extends BaseRepository {

    public void save(SinhVien sv) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(sv);
        em.getTransaction().commit();
        em.close();
    }

    public SinhVien findByMaSv(String maSv) {
        EntityManager em = getEntityManager();
        List<SinhVien> list = em.createQuery(
                        "FROM SinhVien s WHERE s.maSv = :maSv", SinhVien.class)
                .setParameter("maSv", maSv)
                .getResultList();
        em.close();
        return list.isEmpty() ? null : list.get(0);
    }

    public List<SinhVien> findAll() {
        EntityManager em = getEntityManager();
        List<SinhVien> list = em.createQuery("FROM SinhVien", SinhVien.class).getResultList();
        em.close();
        return list;
    }

    public SinhVien findById(Long id) {
        EntityManager em = getEntityManager();
        SinhVien sv = em.find(SinhVien.class, id);
        em.close();
        return sv;
    }
}
