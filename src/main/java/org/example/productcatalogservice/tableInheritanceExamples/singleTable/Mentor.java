package org.example.productcatalogservice.tableInheritanceExamples.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_mentor")
@DiscriminatorValue(value="11")
public class Mentor extends User {

    private Long numberOfHours;
}
