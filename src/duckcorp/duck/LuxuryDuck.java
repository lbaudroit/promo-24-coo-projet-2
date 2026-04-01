package duckcorp.duck;

/**
 * Canard en plastique de luxe.
 *
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class LuxuryDuck extends Duck {

    public static final double BASE_PRICE = 80.0;

    /**
     * Crée un canard de luxe avec son score de qualité.
     * Celui-ci est clampé entre 0 et 100 avant d'être initialisé.
     *
     * @param qualityScore le score de qualité calculé
     */
    protected LuxuryDuck(int qualityScore) {
        super(DuckType.LUXURY, qualityScore);
    }

    @Override
    public double getBasePrice() {
        return BASE_PRICE;
    }

    @Override
    public String describe() {
        return "Canard de Luxe";
    }
}
