package model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private Integer id;
    private String productName;
    private String prodcutCode;
    private Boolean isDeleted;
    private Date importedDate;
    private Date expiredDate;
    private String productDescription;
}
