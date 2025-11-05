package repository;

import entity.HocPhan;
import jakarta.persistence.EntityManager;
import java.util.List;

public class HocPhanRepository extends BaseRepository {

    public void save(HocPhan hp) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(hp);
        em.getTransaction().commit();
        em.close();
    }

    public HocPhan findByMaHp(String maHp) {
        EntityManager em = getEntityManager();
        List<HocPhan> list = em.createQuery(
                        "FROM HocPhan h WHERE h.maHp = :maHp", HocPhan.class)
                .setParameter("maHp", maHp)
                .getResultList();
        em.close();
        return list.isEmpty() ? null : list.get(0);
    }

    public List<HocPhan> findAll() {
        EntityManager em = getEntityManager();
        List<HocPhan> list = em.createQuery("FROM HocPhan", HocPhan.class).getResultList();
        em.close();
        return list;
    }

    public HocPhan findById(Long id) {
        EntityManager em = getEntityManager();
        HocPhan hp = em.find(HocPhan.class, id);
        em.close();
        return hp;
    }

    public void update(HocPhan hp) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(hp);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteById(Long id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        HocPhan hp = em.find(HocPhan.class, id);
        if (hp != null) {
            em.remove(hp); // CascadeType.ALL xóa cả DangKyHoc liên quan
        }
        em.getTransaction().commit();
        em.close();
    }

}
