package pizza.hansal.ma.pizzaRecipes.service;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import pizza.hansal.ma.pizzaRecipes.beans.Produit;
import pizza.hansal.ma.pizzaRecipes.dao.IDao;

public class ProduitService implements IDao<Produit> {

    private List<Produit> produits;

    public ProduitService(){
        this.produits = new ArrayList<>();
    }

    @Override
    public boolean create(Produit o) {
        Log.d("Create : ", o.toString());
        return produits.add(o);
    }

    @Override
    public Produit findById(int id) {
        Log.d("FindById : ", id+"");
        for(Produit p : produits)
            if(p.getId() == id)
                return p;
        return null;
    }

    @Override
    public List<Produit> findAll() {
        Log.d("FindAll : ", produits.size()+"");
        return produits;
    }

    @Override
    public boolean delete(Produit o){
        Log.d("Delete : ", o.toString());
        return produits.remove(o);
    }

    @Override
    public boolean update(Produit o){
        Produit p = findById(o.getId());
        p.setNom(o.getNom());
        p.setNbrIngredients(o.getNbrIngredients());
        p.setPhoto(o.getPhoto());
        p.setDuree(o.getDuree());
        p.setDetailsIngred(o.getDetailsIngred());
        p.setDescription(o.getDescription());
        p.setPreparation(o.getPreparation());
        return false;
    }


}
