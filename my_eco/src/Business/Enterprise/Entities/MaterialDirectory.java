/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Entities;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author keweiji
 */
public class MaterialDirectory {
//    private HashMap<Material,HashMap<Material,Integer>> dict;

    private ArrayList<Material> materials;

    public MaterialDirectory() {
//        this.dict=new HashMap<Material,HashMap<Material,Integer>>();
        this.materials = new ArrayList<Material>();
        addall();

    }

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(ArrayList<Material> materials) {
        this.materials = materials;
    }
    

    public Material addMaterial() {
        Material p = new Material();
        materials.add(p);
        return p;
    }
    
    public void addall() {
        Material handlebars = new Material("Handlebars", new HashMap<Material, Integer>());
//        materials.add(handlebars);
        Material seats = new Material("Seat", new HashMap<Material, Integer>());

        Material spokes = new Material("spokes", new HashMap<Material, Integer>());

        Material tire_rims = new Material("tire_rims", new HashMap<Material, Integer>());

        Material tubing = new Material("tubing", new HashMap<Material, Integer>());

        Material paint = new Material("paint", new HashMap<Material, Integer>());

        HashMap<Material, Integer> wheels_sub = new HashMap<Material, Integer>();
        wheels_sub.put(spokes, 25);
        wheels_sub.put(tire_rims, 1);
        Material wheel = new Material("wheel", wheels_sub);

        HashMap<Material, Integer> frame_sub = new HashMap<Material, Integer>();
        frame_sub.put(tubing, 3);
        frame_sub.put(paint, 1);
        Material frame = new Material("frame", frame_sub);

        HashMap<Material, Integer> frame_assemb_sub = new HashMap<Material, Integer>();
        frame_assemb_sub.put(wheel, 2);
        frame_assemb_sub.put(frame, 1);
        Material frame_assemb = new Material("Frame Assembly", frame_assemb_sub);

        materials.add(handlebars);
        materials.add(frame_assemb);
        materials.add(seats);
        materials.add(wheel);
        materials.add(frame);
        materials.add(spokes);
        materials.add(tire_rims);
        materials.add(tubing);
        materials.add(paint);

    }

}
