package zse.oop.model;

import java.util.List;

public class GrassField extends AbstractWorldMap {

    // znalazlem pomoc w internecie na to co chcialem zrobic
    public GrassField(List<Vector2d> grassPositions) {
        if (grassPositions == null || grassPositions.isEmpty()) {
            throw new IllegalArgumentException("Lista pozycji traw nie może być pusta.");
        }

        for (Vector2d pos : grassPositions) {
            if (!grasses.containsKey(pos) && !animals.containsKey(pos)) {
                Grass g = new Grass(pos);
                placeGrass(g);
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        // Zwierzęta mogą chodzić po całej mapie, o ile nie zajmuje jej inne zwierzę
        return !animals.containsKey(position);
    }
}
