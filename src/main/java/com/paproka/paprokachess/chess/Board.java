package com.paproka.paprokachess.chess;

import com.paproka.paprokachess.pieces.*;

import java.util.Objects;

public class Board {
    Integer tileH;
    Integer tileV;
    Integer [][] boardMatrix;

    public Board (Integer tileH, Integer tileV){
        this.tileH=tileH;
        this.tileV=tileV;
        if (tileH*tileV != 64)
            throw new RuntimeException("Wrong board"); //Board has to have 64 tiles in total (tileH==tileV = 8)
        boardMatrix = null;
    }

    public void generateBoard(Board chess){
        Pawn p = new Pawn("Pawn");
        Tower t = new Tower("Tower");
        Horse h = new Horse("Horse");
        Bishop b = new Bishop("Bishop");
        King k = new King("King");
        Queen q = new Queen("Queen");

        Piece [] prefab = new Piece[]{t, h, b, k, q, b, h, t};
        //Just filling the arrays


        //A matrix for the board. IDK other options
        chess.boardMatrix = new Integer[chess.tileH][chess.tileV];

        //Valid positions
        for (int i=0; i<chess.tileH; i++){
            for (int j=0;j<chess.tileV; j++){
                if ((i==0) || (i==7))
                    chess.boardMatrix[i][j]=setPiece(prefab[j]);
                else if ((i==1) || (i==6))
                    chess.boardMatrix[i][j]=setPiece(p);
                else
                    chess.boardMatrix[i][j]=setPiece(new Piece("Default"));
            }
        }


    }

    private Integer setPiece(Piece p){
        p.setNumOfPieces(p.getNumOfPieces()+1);
        switch (p.getPieceName()) {
            case "Tower" -> {
                return 8;
            }
            case "Horse" -> {
                return 4;
            }
            case "Bishop" -> {
                return 9;
            }
            case "Pawn" -> {
                return 1;
            }
            case "King" -> {
                return 2;
            }
            case "Queen" -> {
                return 3;
            }
            default -> {
                return 0;
            }
        }
    }

    public Integer getTileH() {
        return tileH;
    }

    public void setTileH(Integer tileH) {
        this.tileH = tileH;
    }

    public Integer getTileV() {
        return tileV;
    }

    public void setTileV(Integer tileV) {
        this.tileV = tileV;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(tileH, board.tileH) && Objects.equals(tileV, board.tileV);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tileH, tileV);
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder();
        for (int i=0; i<tileH; i++){
            for (int j=0; j<tileV; j++){
                answer.append(boardMatrix[i][j]);
                answer.append(" ");
            }
            answer.append("\n");
        }
        return answer.toString();
    }
}
