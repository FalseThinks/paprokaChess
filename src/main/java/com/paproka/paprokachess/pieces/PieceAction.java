package com.paproka.paprokachess.pieces;

public interface PieceAction {
    Integer move(Integer path, boolean valid); //Ensure the path and if its valid or not due to other(s) piece(s)
}
