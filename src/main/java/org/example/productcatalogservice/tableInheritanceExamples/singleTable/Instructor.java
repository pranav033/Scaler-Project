package org.example.productcatalogservice.tableInheritanceExamples.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name="st_instructor")
@DiscriminatorValue(value="13")
public class Instructor extends User {
    private String companyName;
}
