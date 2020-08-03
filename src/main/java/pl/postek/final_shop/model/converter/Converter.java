package pl.postek.final_shop.model.converter;

public interface Converter <D, E> {
    D fromEntity(E entity);
    E fromDto(D dto);
}
