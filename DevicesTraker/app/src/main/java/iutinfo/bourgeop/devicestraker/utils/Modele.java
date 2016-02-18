package iutinfo.bourgeop.devicestraker.utils;

import android.app.Activity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

import iutinfo.bourgeop.devicestraker.MainActivity;
import iutinfo.bourgeop.devicestraker.R;

/**
 * Created by Pierre on 02/02/2016.
 */
public class Modele {
    private final String[] tablets;
    private final String[] students;
    private Bundle bundle;

    private HashMap<Integer, Integer> associations = null;

    /* – Constructeur par défaut (lecture de la ressource tablets et initialisation des étudiants à 0 (DISPO)
     – getCount() retourne le nombre de tablettes
     – getStudent(i) retourne l’étudiant qui a obtenu la tablette i (0 si tablette dispo).
             – getTerminal(i) retourne le nom de la tablette i.
             – setStudent(i,e) attribue la tablette i à l’étudiant e (retourne true si ok , false sinon (si l’étudiant a déja une autre
             tablette par exemple).
             – save(Bundle outState) sauvegarde l’tétat du modèle vers le bundle.
             – un constructeur Modele(Bundle bundle) reconstruit le modele à partir du Bundle
             */

    /**
     * Modele
     *
     * @param students
     * @param tablets
     * @param bundle
     */
    public Modele(String[] tablets, String[] students, Bundle bundle) {
        this.tablets = tablets;
        this.students = students;

        // check existence for bundle
        if (bundle != null) {
            associations = (HashMap<Integer, Integer>) bundle.getSerializable("assos");
        } else {
            associations = new HashMap<>();
        }


        for (int i = 0; i < tablets.length; i++) {

            int val = 0;
            if (associations != null) {
                if (associations.containsKey(i)) {
                    val = associations.get(i);

                }
            }

            associations.put(i, val);
        }

    }

    public int getCount() {
        return -1;
    }

    public int getStudent(int i) {
        return 0;
    }

    public int getTerminal(int i) {
        return associations.get(i);
    }

    public boolean setStudent(int student, int tablet) {
        // foreach if student != 0
        if (student != 0) {
            /**
             * CHECK STUDENT ISN'T SET ANYWHERE ELSE
             */
            boolean canContinue = true;
            Iterator<Integer> keys = associations.keySet().iterator();
            while (canContinue && keys.hasNext()) {
                int k = keys.next();

                if (k != tablet && associations.get(k) == student) {
                    canContinue = false;
                }
            }

            if (!canContinue) {
                return false;
            }
        }

        associations.put(tablet, student);

        return true;
    }


    /**
     * @param outState
     */
    public void save(Bundle outState) {
        outState.putSerializable("assos", associations);
    }


}
