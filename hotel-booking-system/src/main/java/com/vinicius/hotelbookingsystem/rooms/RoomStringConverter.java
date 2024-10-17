package com.vinicius.hotelbookingsystem.rooms;

import javafx.util.StringConverter;

public class RoomStringConverter extends StringConverter<RoomEntity> {

    @Override
    public String toString(RoomEntity room) {
        return room != null
                ? room.getRoomType() + " - " + room.getRoomNumber()
                : "";
    }

    @Override
    public RoomEntity fromString(String string) {
        return null;
    }
}
