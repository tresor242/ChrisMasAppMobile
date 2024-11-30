package com.example.christmasapp.data;

import com.example.christmasapp.models.Child;

import java.util.ArrayList;

public class DataStorage {

    // Liste des enfants
    private static ArrayList<Child> children = new ArrayList<>();

    // Informations d'administrateur
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "admin123";

    // Utilisateur connecté
    public static String loggedInUser = null; // Stocke le nom d'utilisateur de l'utilisateur connecté

    /**
     * Ajouter un enfant après vérification des doublons.
     * @param child L'enfant à ajouter.
     * @return true si l'enfant a été ajouté, false si le nom d'utilisateur est déjà pris.
     */
    public static boolean addChild(Child child) {
        if (isUsernameTaken(child.getUsername())) {
            return false; // Nom d'utilisateur déjà utilisé
        }
        children.add(child);
        return true;
    }

    /**
     * Vérifie si un nom d'utilisateur existe déjà parmi les enfants.
     * @param username Le nom d'utilisateur à vérifier.
     * @return true si le nom d'utilisateur est pris, false sinon.
     */
    public static boolean isUsernameTaken(String username) {
        for (Child child : children) {
            if (child.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Supprimer un enfant par son nom d'utilisateur.
     * @param username Le nom d'utilisateur de l'enfant à supprimer.
     * @return true si l'enfant a été supprimé, false sinon.
     */
    public static boolean removeChild(String username) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getUsername().equals(username)) {
                children.remove(i);
                return true; // Suppression réussie
            }
        }
        return false; // Enfant introuvable
    }

    /**
     * Vérifier si les informations de connexion d'un enfant sont valides.
     * @param username Nom d'utilisateur.
     * @param password Mot de passe.
     * @return true si les informations sont valides, false sinon.
     */
    public static boolean isValidChild(String username, String password) {
        for (Child child : children) {
            if (child.getUsername().equals(username) && child.getPassword().equals(password)) {
                loggedInUser = username; // Enregistrer l'utilisateur connecté
                return true;
            }
        }
        return false;
    }

    /**
     * Récupérer la liste de tous les enfants.
     * @return Une liste d'objets Child.
     */
    public static ArrayList<Child> getAllChildren() {
        return children;
    }

    /**
     * Trouver un enfant par son nom d'utilisateur.
     * @param username Le nom d'utilisateur de l'enfant.
     * @return L'objet Child correspondant, ou null si non trouvé.
     */
    public static Child findChildByUsername(String username) {
        for (Child child : children) {
            if (child.getUsername().equals(username)) {
                return child;
            }
        }
        return null;
    }

    /**
     * Mettre à jour les informations d'un enfant existant.
     * @param updatedChild L'enfant avec les informations mises à jour.
     * @return true si la mise à jour a réussi, false sinon.
     */
    public static boolean updateChildInfo(Child updatedChild) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getUsername().equals(updatedChild.getUsername())) {
                children.set(i, updatedChild); // Remplacer l'enfant existant
                return true;
            }
        }
        return false; // Enfant non trouvé
    }

    /**
     * Récupérer les informations de l'utilisateur actuellement connecté.
     * @return L'objet Child correspondant, ou null si aucun utilisateur connecté.
     */
    public static Child getLoggedInChild() {
        if (loggedInUser != null) {
            return findChildByUsername(loggedInUser);
        }
        return null;
    }

    /**
     * Déconnecter l'utilisateur actuellement connecté.
     */
    public static void logout() {
        loggedInUser = null; // Réinitialiser l'utilisateur connecté
    }

    /**
     * Initialiser les données par défaut pour les tests.
     */
    public static void initializeTestData() {
        addChild(new Child("Alice", "Wonderland", 10, "France", "Paris", "alice", "password123"));
        addChild(new Child("Bob", "Builder", 12, "USA", "New York", "bob", "password456"));
    }
}
