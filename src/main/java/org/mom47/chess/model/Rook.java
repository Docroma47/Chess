package org.mom47.chess.model;


public class Rook extends ChessPiece {
    @Override
    public String toString() {
        return "Rook [" + this.getSymbol() + ", " + this.getColor() + ", (" + this.getPosition().getFile() + ", " + this.getPosition().getRank() + ")]";
    }

    public Rook(PieceColour color, String symbol, Point position) {
        super(color, symbol, position);
    }
}