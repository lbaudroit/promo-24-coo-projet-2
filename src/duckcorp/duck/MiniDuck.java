package duckcorp.duck;

/**
 * Canard en plastique miniature.
 *
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class MiniDuck extends Duck {

    public static final double BASE_PRICE = 12.0;

    /**
     * Crée un mini-canard avec son score de qualité.
     * Celui-ci est clampé entre 0 et 100 avant d'être initialisé.
     *
     * @param qualityScore le score de qualité calculé
     */
    public MiniDuck(int qualityScore) {
        super(DuckType.MINI, qualityScore);
    }

    @Override
    public double getBasePrice() {
        return BASE_PRICE;
    }

    @Override
    public String describe() {
        return "Mini Canard";
    }
}
