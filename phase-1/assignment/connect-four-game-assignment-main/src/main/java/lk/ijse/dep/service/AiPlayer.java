package lk.ijse.dep.service;

public class AiPlayer extends Player {

    public AiPlayer(Board newBoard) {
        super(newBoard);

    }

    @Override
    public void movePiece(int col) {
        int newCol;
        do {
            newCol = (int) (Math.random() * 6);


        } while (!board.isLegalMove(newCol));

        board.updateMove(newCol, Piece.GREEN);
        board.getBoardUI().update(newCol, false);

        if (board.findWinner().getWinningPiece()==Piece.EMPTY) {
            if (board.existLegalMoves()) {
                return;
            }
            board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
        } else {
            board.getBoardUI().notifyWinner(new Winner(Piece.GREEN));

        }

    }
}
