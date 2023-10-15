package pizza.hansal.ma.pizzaRecipes.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pizza.hansal.ma.pizzaRecipes.R;
import pizza.hansal.ma.pizzaRecipes.beans.Produit;

import pizza.hansal.ma.pizzaRecipes.beans.Produit;

public class PizzaAdapter extends BaseAdapter {
    private List<Produit> produits;
    private LayoutInflater inflater;

    public PizzaAdapter(Activity activity, List<Produit> produits) {
        this.produits = produits;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount(){
        return produits.size();
    }

    @Override
    public Object getItem(int i){
        return produits.get(i);
    }

    @Override
    public long getItemId(int i){
        return produits.get(i).getId();
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
            view = inflater.inflate(R.layout.pizza_item, null);

        TextView idTextView = view.findViewById(R.id.id);
        idTextView.setText(String.valueOf(produits.get(i).getId()));
        TextView nom = view.findViewById(R.id.nom);
        TextView nbrIngredients = view.findViewById(R.id.nbrIngredients);
        ImageView photo = view.findViewById(R.id.photo);
        TextView duree = view.findViewById(R.id.duree);
//        TextView detailsIngred = view.findViewById(R.id.detailsIngred);
//        TextView description = view.findViewById(R.id.description);
//        TextView preparation = view.findViewById(R.id.preparation);

        nom.setText(produits.get(i).getNom());
        nbrIngredients.setText(produits.get(i).getNbrIngredients() + "");
        photo.setImageResource(produits.get(i).getPhoto());
        duree.setText(produits.get(i).getDuree());
//        detailsIngred.setText(produits.get(i).getDetailsIngred());
//        description.setText(produits.get(i).getDescription());
//        preparation.setText(produits.get(i).getPreparation());

        return view;
    }

}
