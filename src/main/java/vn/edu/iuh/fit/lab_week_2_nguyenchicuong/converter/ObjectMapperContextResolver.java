package vn.edu.iuh.fit.lab_week_2_nguyenchicuong.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;


@Provider
//Xử lí cho việc chuyển  Datetime
public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
final ObjectMapper mapper=new ObjectMapper();
public ObjectMapperContextResolver(){
    mapper.registerModule(new JavaTimeModule());
}
    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}
