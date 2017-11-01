import java.util.ArrayList;

// Implémentation de l'interface IBibliotheque
// à l'aide d'un arbre de recherche binaire.
public class BibliothequeBst implements IBibliotheque
{
    private BST<String> livres = new AvlTree<String>();

    // Complexité: O(log(n))
    // Explication:
    public void ajouterLivre(String livre)
    {
        // À compléter
        livres.insert(livre);
    }

    // Complexité: O(log(n))
    // Explication:
    public boolean contientLivre(String livre)
    {
        // À compléter
        if(!livres.contains(livre))
            return false;
        return true;
    }

    // Complexité: O(n)
    // Explication: Il ne suffit ici que de parcourir
    //              l'arbre de recherche binaire selon
    //              un parcours en ordre/ascendant.
    public String afficherLivresAlpha()
    {
        // À compléter
        ArrayList<String> listLivres = livres.traverseInOrder();
        String aLivres = "";

        for(String elems: listLivres)
            aLivres+= elems + '\n';
        return aLivres;
    }

    // Complexité: O(n)
    // Explication: Il ne suffit ici que de parcourir
    //              l'arbre de recherche binaire selon
    //              un parcours en ordre inverse/descendant.
    public String afficherLivresAlphaInverse()
    {
        // À compléter
        ArrayList<String> listLivres = livres.traverseReverseOrder();
        String aLivres = "";

        for(String elems: listLivres)
            aLivres += elems + '\n';
        return aLivres;
    }
}