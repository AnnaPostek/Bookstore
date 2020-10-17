package pl.postek.final_shop.model.converter;

public interface Converter <E, D> {
    D fromEntity(E entity);
    E fromDto(D dto);
}
