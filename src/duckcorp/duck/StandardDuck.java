package duckcorp.duck;

/**
 * Canard en plastique standard.
 *
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class StandardDuck extends Duck {

    public static final double BASE_PRICE = 25.0;

    /**
     * Crée un canard standard avec son score de qualité.
     * Celui-ci est clampé entre 0 et 100 avant d'être initialisé.
     *
     * @param qualityScore le score de qualité calculé
     */
    public StandardDuck(int qualityScore) {
        super(DuckType.STANDARD, qualityScore);
    }

    @Override
    public double getBasePrice() {
        return BASE_PRICE;
    }

    @Override
    public String describe() {
        return "Canard Standard";
    }
}
