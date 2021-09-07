package ar.com.cartico.casa.gastos.utils.fx;

import ar.com.cartico.casa.gastos.entities.gasto;
import java.lang.reflect.Field;
import java.util.List;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TableFx <E> {
    public void cargar (TableView<E> tbl,List<E> list){
        if(tbl==null)return;
        tbl.getColumns().clear();
        tbl.getItems().clear();
        if(list==null || list.isEmpty())return;
        E e = list.get(0);
        for(Field f: e.getClass().getDeclaredFields()){
            TableColumn c = new TableColumn(f.getName());
            c.setCellValueFactory(new PropertyValueFactory(f.getName()));
            tbl.getColumns().add(c);
        }
        tbl.getItems().addAll(list);
    }   

}
