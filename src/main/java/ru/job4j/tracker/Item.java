//package ru.job4j.tracker;
//
//import ru.job4j.collection.Job;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Comparator;
//import java.util.Objects;
//
//import lombok.Data;
//
//@Data
//public class Item {
//    private int id;
//    private String name;
//    private LocalDateTime created = LocalDateTime.now();
//    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
//
//    public Item() {
//    }
//
//    public Item(String name) {
//        this.name = name;
//    }
//
//    public Item(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Item(int id, String name, LocalDateTime created) {
//        this.id = id;
//        this.name = name;
//        this.created = created;
//    }
//
////    public int getId() {
////        return id;
////    }
////
////    public void setId(int id) {
////        this.id = id;
////    }
////
////    public String getName() {
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////
////    public LocalDateTime getCreated() {
////        return created;
////    }
//
//    @Override
//    public String toString() {
//        return "Item{"
//                + "id=" + id
//                + ", name='" + name + '\''
//                + ", created=" + created.format(FORMATTER)
//                + '}';
////        return String.format("id: %s, name: %s, created: %s", id, name, FORMATTER.format(created));
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Item item = (Item) o;
//        return Objects.equals(name, item.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
//}

//package ru.job4j.tracker;
//
//import lombok.Data;
//import javax.persistence.*;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "items")
//@Data
//public class Item {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private String name;
//    private LocalDateTime created = LocalDateTime.now();
//}

package ru.job4j.tracker;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Item {

    private static final DateTimeFormatter FORMATTER
            = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private int id;

    @EqualsAndHashCode.Include
    @ToString.Include
    @NonNull
    private String name;

    private LocalDateTime created = LocalDateTime.now();

    public Item(int id, @NonNull String name) {
        this.id = id;
        this.name = name;
    }

    @ToString.Include
    String created() {
        return FORMATTER.format(created);
    }

}