package ru.job4j.tracker;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class DateRun {
    public static void main(String[] args) {
        var registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (var sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            var session = sf
                    .withOptions()
                    .jdbcTimeZone(TimeZone.getTimeZone("UTC")) // .jdbcTimeZone(TimeZone.getTimeZone("America/Los_Angeles"))
                    .openSession();
            session.beginTransaction();
            var item = new Item();
            item.setName("check timezone");
            item.setCreated(LocalDateTime.now());
            session.persist(item);
            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}

//package ru.job4j.tracker;
//
//        import java.time.ZoneId;
//        import java.time.format.DateTimeFormatter;
//        import org.hibernate.boot.MetadataSources;
//        import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//        import ru.job4j.tracker.model.Item;
//
//public class DateRun {
//
//    public static void main(String[] args) {
//        var registry = new StandardServiceRegistryBuilder()
//                .configure().build();
//        try (var sf = new MetadataSources(registry)
//                .buildMetadata().buildSessionFactory()) {
//            var session = sf.openSession();
//            session.beginTransaction();
//            var stored = session.createQuery("FROM Item", Item.class).list();
//            for (Item it : stored) {
//                var time = it.getCreated()
//                        .atZone(ZoneId.of("GMT+11"))
//                        .withZoneSameInstant(ZoneId.of("UTC+3"))
//                        .format(DateTimeFormatter.ofPattern("HH:mm yyyy-MM-dd"));
//                System.out.println(time);
//            }
//            session.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            StandardServiceRegistryBuilder.destroy(registry);
//        }
//    }
//
//}