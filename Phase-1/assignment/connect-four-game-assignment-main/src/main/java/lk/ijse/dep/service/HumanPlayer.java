package lk.ijse.dep.service;

public class HumanPlayer extends Player {


    public HumanPlayer(Board newBoard) {
        super(newBoard);
    }

    @Override
    public void movePiece(int col) {

        if (!board.isLegalMove(col)) return;

        board.updateMove(col, Piece.BLUE);
        board.getBoardUI().update(col, true);
        if (board.findWinner().getWinningPiece() != Piece.EMPTY) {
            board.getBoardUI().notifyWinner(board.findWinner());
        } else {
            if (!board.existLegalMoves()) {
                board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));

            }

        }


    }
}
