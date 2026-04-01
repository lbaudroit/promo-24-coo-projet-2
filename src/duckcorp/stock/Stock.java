package duckcorp.stock;

import duckcorp.duck.Duck;
import duckcorp.duck.DuckType;
import duckcorp.duck.Qualifiable;

import java.util.*;

/**
 * Stock générique de canards.
 *
 * @param <T> type de canard stocké (doit étendre Duck)
 * @author Roussille Philippe <roussille@3il.fr>
 */
public class Stock<T extends Duck> {

    private final List<T> items = new ArrayList<>();

    // --- Méthodes fournies ---

    /** Ajoute un canard au stock. */
    public void add(T duck) {
        items.add(duck);
    }

    /** Retourne une vue non modifiable de tous les canards en stock. */
    public List<T> getAll() {
        return Collections.unmodifiableList(items);
    }

    /** Retourne le nombre total de canards en stock. */
    public int total() {
        return items.size();
    }

    /**
     * Retire exactement {@code count} canards du type {@code type} du stock
     * et les retourne dans une liste.
     *
     * @param type  le type de canard à retirer
     * @param count le nombre à retirer
     * @return la liste des canards retirés
     * @throws IllegalStateException si le stock ne contient pas assez de canards du type demandé
     *
     * Conseil : parcourez items en une seule passe.
     * Attention à la signature de retour : elle doit conserver le type générique T.
     */
    public List<T> remove(DuckType type, int count) {
        Iterator<T> ite = items.iterator();
        List<T> candidates = new ArrayList<>(count);

        while (ite.hasNext()) {
            T next = ite.next();
            if (next.getType().equals(type) && candidates.size() < count) {
                candidates.add(next);
            }
        }

        if (candidates.size() < count) {
            throw new IllegalStateException("Pas assez de canards supprimables en stock !");
        }
        items.removeAll(candidates);
        return candidates;
    }

    /**
     * Retourne le nombre de canards du type {@code type} présents dans le stock.
     * Si le nombre de canards déclenche un overflow, on renvoie {@link Integer#MAX_VALUE}
     *
     * @param type le type à compter
     */
    public int count(DuckType type) {
        try {
            long count = items.stream().filter(d -> d.getType().equals(type)).count();
            return Math.toIntExact(count);
        } catch (ArithmeticException e) {
            return Integer.MAX_VALUE;
        }
    }

    /**
     * Retourne le nombre de canards défectueux dans le stock.
     * Un canard est défectueux si isDefective() retourne true.
     * Si le nombre de canards déclenche un overflow, on renvoie {@link Integer#MAX_VALUE}
     *
     * Conseil : appelez isDefective() plutôt que de comparer le score manuellement.
     */
    public int countDefective() {
        try {
            long count = items.stream().filter(Qualifiable::isDefective).count();
            return Math.toIntExact(count);
        } catch (ArithmeticException e) {
            return Integer.MAX_VALUE;
        }
    }

    /**
     * Retourne une Map associant chaque DuckType au nombre de canards
     * de ce type présents dans le stock.
     *
     * Conseil : construisez la map en une seule passe sur items.
     * Tous les types doivent apparaître dans la map (avec 0 si absent).
     */
    public Map<DuckType, Integer> countByType() {
        Map<DuckType, Integer> counts = new HashMap<>(DuckType.values().length);
        for (T item : items) {
            DuckType type = item.getType();
            counts.merge(type, 1, (current, _value) -> current + 1);
        }
        for (DuckType type : DuckType.values()) {
            counts.putIfAbsent(type, 0);
        }
        return counts;
    }
}
