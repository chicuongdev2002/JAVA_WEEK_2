package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.enums.ProductStatus;


import java.util.stream.Stream;
//Xử lí cho việc chuyển từ emum sang interger
@Converter(autoApply = true)

public class ProductStatusConverter implements AttributeConverter<ProductStatus,Integer> {
    @Override
    public Integer convertToDatabaseColumn(ProductStatus attribute) {
        if(attribute==null)
        return null;
        return attribute.getValue();
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        } else {
            return Stream.of(ProductStatus.values()).filter(c -> c.getValue() == dbData).findFirst().orElseThrow(IllegalArgumentException::new);
        }
    }
}
