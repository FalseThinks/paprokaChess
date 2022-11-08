package com.paproka.paprokachess.pieces;

import java.util.Objects;

public class Piece {
    Integer numOfPieces;
    String pieceName;

    public Piece(String pieceName){
        numOfPieces=0;
        this.pieceName=pieceName;
    }

    public Integer addPiece(Piece p){
        return p.numOfPieces++;
    }

    public Boolean checkPieces(Piece p){
        Integer num = p.numOfPieces;
        switch (p.getPieceName()) {
            case "Tower", "Horse", "Bishop" -> {
                return num <= 2;
            }
            case "King", "Queen" -> {
                return num == 1;
            }
            case "Pawn" -> {
                return num <= 8;
            }
            default -> {
                throw new RuntimeException();
            }
        }
    }

    public Integer getNumOfPieces() {
        return numOfPieces;
    }

    public void setNumOfPieces(Integer numOfPieces) {
        this.numOfPieces = numOfPieces;
    }

    public String getPieceName() {
        return pieceName;
    }

    public void setPieceName(String pieceName) {
        this.pieceName = pieceName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(numOfPieces, piece.numOfPieces) && Objects.equals(pieceName, piece.pieceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numOfPieces, pieceName);
    }
}
