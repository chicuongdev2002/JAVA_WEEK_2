package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import vn.edu.iuh.fit.lab_week_2_nguyenchicuong.enums.EmployeeStatus;


import java.util.stream.Stream;
//Xử lí chuyển đổi từ Enum sang Interger
@Converter(autoApply = true)
public class EmployeeStatusConverter  implements AttributeConverter<EmployeeStatus,Integer> {

    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus attribute) {
        if(attribute==null)
        return null;
        return attribute.getValue();
    }

    @Override
    public EmployeeStatus convertToEntityAttribute(Integer dbData) {
        if(dbData==null) {
            return null;
        }else
        {
            return Stream.of(EmployeeStatus.values()).filter(c->c.getValue()==dbData).findFirst().orElseThrow(IllegalArgumentException::new);
        }

    }
}
