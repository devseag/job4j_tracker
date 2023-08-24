package ru.job4j.tracker;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Collections;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    /**
     * Dobavit' novuju zajavku.
     * @param item zajavka.
     * @return zajavka s ID.
     */
    @Override
    public Item add(Item item) {
        var session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return item;
    }

    /**
     * Obnovit' zajavku v BD.
     * @param id ID.
     * @param item zajavka.
     * @return true/false.
     */
    @Override
    public boolean replace(int id, Item item) {
        var result = false;
        var session = sf.openSession();
        try {
            session.beginTransaction();
            result = session.createQuery(
                            "UPDATE Item SET name = :fName, created = :fCreated WHERE id = :fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fCreated", item.getCreated())
                    .setParameter("fId", id)
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    /**
     * Udalit' zajavku po ID.
     * @param id ID.
     * @return true/false;
     */
    @Override
    public boolean delete(int id) {
        var result = false;
        var session = sf.openSession();
        try {
            session.beginTransaction();
            result = session.createQuery(
                            "DELETE Item WHERE id = :fId")
                    .setParameter(":fId", id)
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    /**
     * Spisok vseh zajavok.
     * @return spisok zajavok.
     */
    @Override
    public List<Item> findAll() {
        var session = sf.openSession();
        List<Item> result = Collections.emptyList();
        try {
            session.beginTransaction();
            result = session.createQuery("FROM Item", Item.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    /**
     * Spisok zajavok najdennyh po imeni.
     * @param key kljuch poiska.
     * @return spisok zajavok.
     */
    @Override
    public List<Item> findByName(String key) {
        var session = sf.openSession();
        List<Item> result = Collections.emptyList();
        try {
            session.beginTransaction();
            result = session.createQuery("FROM Item WHERE name = :fName", Item.class)
                    .setParameter("fName", key)
                    .list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    /**
     * Najti zajavku po ID.
     * @param id ID.
     * @return zajavka.
     */
    @Override
    public Item findById(int id) {
        var session = sf.openSession();
        Item result = null;
        try {
            session.beginTransaction();
            result = session.createQuery("FROM Item WHERE id = :fId", Item.class)
                    .setParameter("fId", id)
                    .uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public void close() {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}