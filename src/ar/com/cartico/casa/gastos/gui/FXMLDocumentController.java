package ar.com.cartico.casa.gastos.gui;

import ar.com.cartico.casa.gastos.connector.Connector;
import ar.com.cartico.casa.gastos.entities.gasto;
import ar.com.cartico.casa.gastos.entities.persona;
import ar.com.cartico.casa.gastos.enums.Meses;
import ar.com.cartico.casa.gastos.repositories.implementation.CasaR;
import ar.com.cartico.casa.gastos.repositories.implementation.GastoFijoR;
import ar.com.cartico.casa.gastos.repositories.implementation.GastoR;
import ar.com.cartico.casa.gastos.repositories.implementation.PersonaR;
import ar.com.cartico.casa.gastos.repositories.interfaz.I_CasaRepository;
import ar.com.cartico.casa.gastos.repositories.interfaz.I_GastoRepository;
import ar.com.cartico.casa.gastos.repositories.interfaz.I_PersonaRepository;
import ar.com.cartico.casa.gastos.utils.fx.TableFx;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLDocumentController implements Initializable {
    private I_GastoRepository gr;
    private I_GastoRepository gfr;
    private I_PersonaRepository pr;
    private I_CasaRepository cr;
    private Calendar calendario;
    
    private int idMiembro;
    private int deudaMiembro;
    
    private int idGastoFijo;
    
    private int idGasto;
    private final List<Meses> listaMes = new ArrayList();//Se carga la lista de meses
    
    private boolean filtroAnalisis;
    private String tipoFiltroAnalisis;
    private String valorFiltroAnalisis;
    
    @FXML private Label lblBienvenide;
    @FXML private TableView<persona> tblMiembros;
    @FXML private Button btnAgregarMiembro;
    @FXML private Button btnModificarMiembro;
    @FXML private Button btnEliminarMiembro;
    @FXML private ComboBox<Integer> cmbImplicanciaG;
    @FXML private ComboBox<Integer> cmbImplicanciaGF;
    @FXML private ComboBox<persona> cmbEliminarMiembro;
    @FXML private TextField txtNombreCasa;
    @FXML private TextField txtAgregarMiembro;
    @FXML private TableView<gasto> tblGastoFijo;
    @FXML private ComboBox<Meses> cmbMesGastoFijo;
    @FXML private TextField txtA??oGastoFijo;
    @FXML private ComboBox<persona> cmbMiembroGastoFijo;
    @FXML private ComboBox<String> cmbDetalleGastoFijo;
    @FXML private TextField txtMontoGastoFijo;
    @FXML private TextField txtDetalleGastoFijo;
    @FXML private Label lblErrorAgregarGastoFijo;
    @FXML private Label lblErrorUpdateGastoFijo;
    @FXML private ComboBox<String> cmbFiltroGastoFijo;
    @FXML private ComboBox<Object> cmbTipoBusquedaGastoFijo;
    @FXML private Label lblErrorDeleteGastoFijo;
    @FXML private Label lblA??oGastoFijo;
    @FXML private Label lblDetalleGastoFijo;
    @FXML private Label lblMontoGastoFijo;
    @FXML private Label lblErrorBusquedaGastoFijo;
    @FXML private ComboBox<String> cmbTipoBusquedaGastoFijoDos;
    @FXML private TableView<gasto> tblGasto;
    @FXML private ComboBox<Meses> cmbMesGasto;
    @FXML private ComboBox<persona> cmbMiembroGasto;
    @FXML private ComboBox<String> cmbDetalleGasto;
    @FXML private TextField txtMontoGasto;
    @FXML private TextField txtDetalleGasto;
    @FXML private Label lblErrorAgregarGasto;
    @FXML private Label lblErrorUpdateGasto;
    @FXML private ComboBox<String> cmbFiltroGasto;
    @FXML private ComboBox<Object> cmbTipoBusquedaGasto;
    @FXML private Label lblErrorDeleteGasto;
    @FXML private Label lblA??oGasto;
    @FXML private Label lblDetalleGasto;
    @FXML private Label lblMontoGasto;
    @FXML private Label lblErrorBusquedaGasto;
    @FXML private ComboBox<String> cmbTipoBusquedaGastoDos;
    @FXML private TextField txtA??oGasto;
    @FXML private TextField txtTotal;
    @FXML private TextField txtTotalA??oActual;
    @FXML private TextField txtTotalMesActual;
    @FXML private ComboBox<String> cmbOtroA??o;
    @FXML private ComboBox<Meses> cmbOtroMes;
    @FXML private ComboBox<String> cmbOtroMesA??o;
    @FXML private TextField txtTotalA??o;
    @FXML private TextField txtTotalMes;
    @FXML private ComboBox<String> cmbTipoFiltroAnalisis;
    @FXML private ComboBox<Object> cmbFiltroAnalisis;
    @FXML private TextField txtTotalGF;
    @FXML private TextField txtTotalA??oActualGF;
    @FXML private TextField txtTotalMesActualGF;
    @FXML private ComboBox<String> cmbOtroA??oGF;
    @FXML private ComboBox<Meses> cmbOtroMesGF;
    @FXML private ComboBox<String> cmbOtroMesA??oGF;
    @FXML private TextField txtTotalA??oGF;
    @FXML private TextField txtTotalMesGF;
    @FXML private TextField txtTotalGlobal;
    @FXML private TextField txtTotalA??oActualGlobal;
    @FXML private TextField txtTotalMesActualGlobal;
    @FXML private Label lblErrorAnalisis;
    @FXML private TextArea txaDeudaMiembroG;
    @FXML private TextArea txaDeudaMontoG;
    @FXML private TextArea txaDeudaMiembroGF;
    @FXML private TextArea txaDeudaMontoGF;
    @FXML private ComboBox<persona> cmbDeudaMiembro1;
    @FXML private ComboBox<persona> cmbDeudaMiembro2;
    @FXML private TextField txtDeudaMonto;
    @FXML private ComboBox<String> cmbDeudaGasto;
    @FXML private Label lblErrorDeuda;
    
    
           
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gr = new GastoR(Connector.getConnection());
        gfr = new GastoFijoR(Connector.getConnection());
        pr = new PersonaR(Connector.getConnection());
        cr= new CasaR(Connector.getConnection());
        
        calendario = Calendar.getInstance(); //Se instancia el calendario
        
        //Se carga la lista de meses  
        listaMes.add(Meses.ENERO);
        listaMes.add(Meses.FEBRERO);
        listaMes.add(Meses.MARZO);
        listaMes.add(Meses.ABRIL);
        listaMes.add(Meses.MAYO);
        listaMes.add(Meses.JUNIO);
        listaMes.add(Meses.JULIO);
        listaMes.add(Meses.AGOSTO);
        listaMes.add(Meses.SEPTIEMBRE);
        listaMes.add(Meses.OCTUBRE);
        listaMes.add(Meses.NOVIEMBRE);
        listaMes.add(Meses.DICIEMBRE);
        
        cargar(); //Carga la pesta??a de inicio
        
        
    }    
    
    private void cargar(){
        
    //Pesta??a de inicio
        //Cargar id persona
        idMiembro=0;
        deudaMiembro = 0;
        //Cargar el como box de eliminar miembros
        cmbEliminarMiembro.getItems().clear();
        cmbEliminarMiembro.getItems().addAll(pr.getAll());
        cmbEliminarMiembro.getSelectionModel().selectFirst();
        
        //Cargar los combo box de implicancia
        cmbImplicanciaG.getItems().clear();
        cmbImplicanciaG.getItems().addAll(0,1,2,3);
        cmbImplicanciaG.getSelectionModel().selectFirst();
        
        cmbImplicanciaGF.getItems().clear();
        cmbImplicanciaGF.getItems().addAll(0,1,2,3);
        cmbImplicanciaGF.getSelectionModel().selectFirst();
        
        //Cargar label de Bienvenida
        lblBienvenide.setText("Bienvenide al sistema de gastos de la casa "+ cr.getByNombre().getNombre());
        
        //Cargar tabla de miembros
        new TableFx<persona>().cargar(tblMiembros, pr.getAll());
        
        //Cargar txt nombre de casa y miembros
        txtAgregarMiembro.setText("");
        txtNombreCasa.setText("");
    
    //Pesta??a gasto fijo
         // cargar el valor de id Gasto Fijo
        idGastoFijo=0;
        
        //Cargar Tabla de Gastos Fijos
        new TableFx<gasto>().cargar(tblGastoFijo, gfr.getAll());
        
        //Cargar El combo Box de meses
       
         cmbMesGastoFijo.getItems().clear();
         cmbMesGastoFijo.getItems().addAll(listaMes);
         cmbMesGastoFijo.getSelectionModel().select(calendario.get(Calendar.MONTH));
    
         //Cargar el combo box de miembros
         cmbMiembroGastoFijo.getItems().clear();
         cmbMiembroGastoFijo.getItems().addAll(pr.getAll());
         cmbMiembroGastoFijo.getSelectionModel().selectFirst();
         
         //Cargar el combo box de detalle
         cmbDetalleGastoFijo.getItems().clear();
         cmbDetalleGastoFijo.getItems().addAll(gfr.getDetalles());
         cmbDetalleGastoFijo.getSelectionModel().selectFirst();
         
         //Cargar cmb filtro
         cmbFiltroGastoFijo.getItems().clear();
         cmbFiltroGastoFijo.getItems().addAll("Filtro", "Miembro", "Mes", "A??o", "Mes y A??o", "Detalle");
         cmbFiltroGastoFijo.getSelectionModel().selectFirst();
         
         //Cargar opacidad combobox de busqueda
         cmbTipoBusquedaGastoFijo.setOpacity(0);
         cmbTipoBusquedaGastoFijoDos.setOpacity(0);
        
         //Cargar El campo de Texto A??o
         txtA??oGastoFijo.setText(Integer.toString(calendario.get(Calendar.YEAR)));
                 
         
         //Cargar campo de texto detalle
         if(cmbDetalleGastoFijo.getValue().equalsIgnoreCase("Otro")){
             txtDetalleGastoFijo.setOpacity(1);
         }else{
             txtDetalleGastoFijo.setOpacity(0);
         }
         
         //Cargar labels
         lblA??oGastoFijo.setText("");
         lblMontoGastoFijo.setText("");
         lblDetalleGastoFijo.setText("");
         lblErrorAgregarGastoFijo.setText("");
         lblErrorUpdateGastoFijo.setText("");
         lblErrorDeleteGastoFijo.setText("");
         lblErrorBusquedaGastoFijo.setText("");
         
         //Cargar el campo de texto monto
         txtMontoGastoFijo.setText("0");
              
    //Cargar Pesta??a Gasto
         //Cargar el valor de IdGasto
         idGasto = 0;
         
         //Cargar tabla de gasto
         new TableFx<gasto>().cargar(tblGasto,gr.getAll());
         
         //Cargar CMB Detalle de Gasto
         cmbDetalleGasto.getItems().clear();
         cmbDetalleGasto.getItems().addAll(gr.getDetalles());
         cmbDetalleGasto.getSelectionModel().selectFirst();
         
         //Cargar CMB Meses de Gasto
         cmbMesGasto.getItems().clear();
         cmbMesGasto.getItems().addAll(listaMes);
         cmbMesGasto.getSelectionModel().select(calendario.get(Calendar.MONTH));
         
         //Cargar CMB Miembro de Gasto
         cmbMiembroGasto.getItems().clear();
         cmbMiembroGasto.getItems().addAll(pr.getAll());
         cmbMiembroGasto.getSelectionModel().selectFirst();
         
         //Cargar CMB Filtro de Gasto
         cmbFiltroGasto.getItems().clear();
         cmbFiltroGasto.getItems().addAll("Filtro", "Miembro", "Mes", "A??o", "Mes y A??o", "Detalle");
         cmbFiltroGasto.getSelectionModel().selectFirst();
        
         //Cargar opacidad CMB de busqueda
         cmbTipoBusquedaGasto.setOpacity(0);
         cmbTipoBusquedaGastoDos.setOpacity(0);
         
         //cargar lbls
         lblA??oGasto.setText("");
         lblDetalleGasto.setText("");
         lblErrorAgregarGasto.setText("");
         lblErrorBusquedaGasto.setText("");
         lblErrorDeleteGasto.setText("");
         lblErrorUpdateGasto.setText("");
         lblMontoGasto.setText("");
         
         //Cargar TXT A??o de Gasto
         txtA??oGasto.setText(Integer.toString(calendario.get(Calendar.YEAR)));
         
         //Cargar TXT Monto de Gasto
         txtMontoGasto.setText("0");
         
         //Cargar TXT Detalle de Gasto
         if(cmbDetalleGasto.getValue().equalsIgnoreCase("Otro")){
             txtDetalleGasto.setOpacity(1);
         } else txtDetalleGasto.setOpacity(0);
    
    // Cargar los elementos de la pesta??a Analisis
       
        //cargar el booleano de filtro
        filtroAnalisis=false;
        
        //cargo los valores de filtro
        tipoFiltroAnalisis = "";
        valorFiltroAnalisis = "";
        
        //Cargo el cmb de tipo de filtro de gasto.
        cmbTipoFiltroAnalisis.getItems().clear();
        cmbTipoFiltroAnalisis.getItems().addAll("Seleccione","Miembro","Detalle");
        cmbTipoFiltroAnalisis.getSelectionModel().selectFirst();
       
        //Cargo el cmb de filtro gasto
        cmbFiltroAnalisis.setOpacity(0);
        
        //Cargo el cmb de otro a??o gasto
        cmbOtroA??o.getItems().clear();
        cmbOtroA??o.getItems().addAll(gr.getA??os());
        cmbOtroA??o.getSelectionModel().select(Integer.toString(calendario.get(Calendar.YEAR)));
        
        //Cargo el cmb de otro mes gasto
        cmbOtroMes.getItems().clear();
        cmbOtroMes.getItems().addAll(listaMes);
        cmbOtroMes.getSelectionModel().select(calendario.get(Calendar.MONTH));
        
        //Cargo el cmb de otro mes a??o gasto
        cmbOtroMesA??o.getItems().clear();
        cmbOtroMesA??o.getItems().addAll(gr.getA??os());
        cmbOtroMesA??o.getSelectionModel().select(Integer.toString(calendario.get(Calendar.YEAR)));
        
        //Cargo el cmb de otro a??o gasto fijo
        cmbOtroA??oGF.getItems().clear();
        cmbOtroA??oGF.getItems().addAll(gfr.getA??os());
        cmbOtroA??oGF.getSelectionModel().select(Integer.toString(calendario.get(Calendar.YEAR)));
        
        //Cargo el cmb de otro mes gasto fijo
        cmbOtroMesGF.getItems().clear();
        cmbOtroMesGF.getItems().addAll(listaMes);
        cmbOtroMesGF.getSelectionModel().select(calendario.get(Calendar.MONTH));
        
        //Cargo el cmb de otro mes a??o gasto fijo
        cmbOtroMesA??oGF.getItems().clear();
        cmbOtroMesA??oGF.getItems().addAll(gr.getA??os());
        cmbOtroMesA??oGF.getSelectionModel().select(Integer.toString(calendario.get(Calendar.YEAR)));
        
        //Cargo los txt de gasto
        txtTotal.setText((Integer.toString(gr.getTotal())));
        txtTotalA??oActual.setText(Integer.toString(gr.getTotalByA??o(calendario.get(Calendar.YEAR))));
        txtTotalA??o.setText(Integer.toString(gr.getTotalByA??o(Integer.parseInt(cmbOtroA??o.getValue()))));
        txtTotalMesActual.setText(Integer.toString(gr.getTotalByMesesA??o(calendario.get(Calendar.YEAR),listaMes.get(calendario.get(Calendar.MONTH)))));
        txtTotalMes.setText(Integer.toString(gr.getTotalByMesesA??o(Integer.parseInt(cmbOtroMesA??o.getValue()),cmbOtroMes.getValue())));
        
        //Cargo los txt de gasto fijo
        txtTotalGF.setText((Integer.toString(gfr.getTotal())));
        txtTotalA??oActualGF.setText(Integer.toString(gfr.getTotalByA??o(calendario.get(Calendar.YEAR))));
        txtTotalA??oGF.setText(Integer.toString(gfr.getTotalByA??o(Integer.parseInt(cmbOtroA??oGF.getValue()))));
        txtTotalMesActualGF.setText(Integer.toString(gfr.getTotalByMesesA??o(calendario.get(Calendar.YEAR),listaMes.get(calendario.get(Calendar.MONTH)))));
        txtTotalMesGF.setText(Integer.toString(gfr.getTotalByMesesA??o(Integer.parseInt(cmbOtroMesA??oGF.getValue()),cmbOtroMesGF.getValue())));
        
        //Cargo los txt Globales
        txtTotalGlobal.setText(Integer.toString(Integer.parseInt(txtTotal.getText())+Integer.parseInt(txtTotalGF.getText())));
        txtTotalMesActualGlobal.setText(Integer.toString(Integer.parseInt(txtTotalMesActual.getText())+Integer.parseInt(txtTotalMesActualGF.getText())));
        txtTotalA??oActualGlobal.setText(Integer.toString(Integer.parseInt(txtTotalA??oActual.getText())+Integer.parseInt(txtTotalA??oActualGF.getText())));
        
        //Cargar el lbl de error
        lblErrorAnalisis.setText("");
        
    //Cargo los elementos de la pesta??a deuda
        //Cargo el txa miembro de gasto corriente
        String deudaMiembroG = "";
        for(gasto g: gr.getDeuda()){
            persona p1 = pr.getById(g.getIdPersona());
            deudaMiembroG += p1.toString() + "("+ p1.getImplicanciaG() +")\n";
        }
        txaDeudaMiembroG.setText(deudaMiembroG);
        
        //Cargo el txa monto de gasto corriente
        String deudaMontoG="";
        for(gasto g : gr.getDeuda()){
            if(g.getMonto()<0) deudaMontoG +="A favor " + (g.getMonto()*-1) + "\n";
            if(g.getMonto()>0) deudaMontoG +="Debe " + g.getMonto() + "\n";
            if(g.getMonto()==0) deudaMontoG +="" + g.getMonto() + "\n";
        }
        txaDeudaMontoG.setText(deudaMontoG);
        
        //Cargo el txa miembro de gasto fijo
        String deudaMiembroGF = "";
        for(gasto g: gfr.getDeuda()){
            persona p1 = pr.getById(g.getIdPersona());
            deudaMiembroGF += p1.toString() + "("+ p1.getImplicanciaGF() +")\n";
        }
        txaDeudaMiembroGF.setText(deudaMiembroGF);
        
        //Cargo el txa monto de gasto corriente
        String deudaMontoGF="";
        for(gasto g : gfr.getDeuda()){
            if(g.getMonto()<0) deudaMontoGF +="A favor " + (g.getMonto()*-1) + "\n";
            if(g.getMonto()>0) deudaMontoGF +="Debe " + g.getMonto() + "\n";
            if(g.getMonto()==0) deudaMontoGF +="" + g.getMonto() + "\n";
        }
        txaDeudaMontoGF.setText(deudaMontoGF);
        
        //Cargo los combobox
        cmbDeudaMiembro1.getItems().clear();
        cmbDeudaMiembro1.getItems().addAll(pr.getAll());
        cmbDeudaMiembro1.getSelectionModel().selectFirst();
        
        cmbDeudaMiembro2.getItems().clear();
        cmbDeudaMiembro2.getItems().addAll(pr.getAll());
        cmbDeudaMiembro2.getSelectionModel().selectFirst();
        
        cmbDeudaGasto.getItems().clear();
        cmbDeudaGasto.getItems().addAll("Corriente", "Fijo");
        cmbDeudaGasto.getSelectionModel().selectFirst();
        
        //Cargo el label de error
        lblErrorDeuda.setText("");
        
    }
    
    /**
     * Estos son los eventos de la pesta??a Inicio
     * @param event 
     */
    @FXML //Modificaci??n en el nombre de Casa
    private void UpdateCasa(ActionEvent event) {
        if(txtNombreCasa==null)return;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Cambiar nombre de casa.");
        alert.setContentText("??Esta segure de que desea modificar el nombre de casa?");
        if(alert.showAndWait().get()==ButtonType.OK) 
        {cr.modificar(txtNombreCasa.getText());}
        cargar();
    }

    @FXML //Metodo para agregar un miembro
    private void AgregarMiembro(ActionEvent event) {
        if(txtAgregarMiembro==null)return;
        pr.save(new persona(
                txtAgregarMiembro.getText(),
                cmbImplicanciaG.getValue(),
                cmbImplicanciaGF.getValue()
        ));
        cargar();
        
    }

    @FXML //Metodo para modificar miembro
    private void UpdateMiembro(ActionEvent event) {
        if(txtAgregarMiembro==null || idMiembro==0)return;
        pr.update(new persona(
                idMiembro,
                txtAgregarMiembro.getText(), 
                cmbImplicanciaG.getValue(), 
                cmbImplicanciaGF.getValue()
        ));
        cargar();
    }
    
    @FXML
    private void seleccionarMiembro(MouseEvent event) {
        idMiembro= tblMiembros.getSelectionModel().getSelectedItem().getId();
        txtAgregarMiembro.setText(tblMiembros.getSelectionModel().getSelectedItem().getNombre());
        cmbImplicanciaG.getSelectionModel().select(tblMiembros.getSelectionModel().getSelectedItem().getImplicanciaG());
        cmbImplicanciaGF.getSelectionModel().select(tblMiembros.getSelectionModel().getSelectedItem().getImplicanciaGF());
    }

    @FXML //Metodo para eliminar miembros
    private void EliminarMiembro(ActionEvent event) {
       if(gfr.getByPersona(cmbEliminarMiembro.getValue()).isEmpty()
               && gr.getByPersona(cmbEliminarMiembro.getValue()).isEmpty()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Eliminar miembro");
        alert.setContentText("??Esta segure de que desea eliminar a "+ cmbEliminarMiembro.getValue().getNombre());
        if(alert.showAndWait().get()==ButtonType.OK){
            pr.remove(cmbEliminarMiembro.getValue());}
        cargar();
       } else {
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText("Error al eliminar.");
           alert.setContentText("Este miembro posee gastos a su nombre y no se puede eliminar."
                   + "\nModifique los gastos para proseguir");
           if(alert.showAndWait().get()==ButtonType.OK){
           }
       }   
    }
    
    /**
     * Estos son los eventos de la pesta??a Gasto Fijo
     * @param event 
     * */
    @FXML //Controlo la opacidad del campo de texto Detalle de gasto Fijo
    private void OtroDetalleGastoFijo(ActionEvent event) {
        if (cmbDetalleGastoFijo.getValue().equalsIgnoreCase("Otro")){
            txtDetalleGastoFijo.setOpacity(1);
            txtDetalleGastoFijo.requestFocus();
        } else txtDetalleGastoFijo.setOpacity(0);
    }
    
    //Sirve para corroborar que el gasto fijo tenga los datos necesarios.
    private boolean validarGastoFijo(){
        //Validar A??o
        try {
            int a??o= Integer.parseInt(txtA??oGastoFijo.getText());
            if(a??o<2013 || a??o>calendario.get(Calendar.YEAR)){
                lblA??oGastoFijo.setText("El a??o esta fuera de rango.");
                txtA??oGastoFijo.selectAll();
                txtA??oGastoFijo.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            lblA??oGastoFijo.setText("El a??o debe ser un n??mero entero");
            txtA??oGastoFijo.selectAll();
            txtA??oGastoFijo.requestFocus();
        }
        //validar detalle
        if (cmbDetalleGastoFijo.getSelectionModel().getSelectedItem().equalsIgnoreCase("Otro") &&
                txtDetalleGastoFijo.getText().equals("")){
            lblDetalleGastoFijo.setText("Asigne el nuevo detalle.");
            txtDetalleGastoFijo.requestFocus();
            return false;
        }
        //Validar Monto
        try {
            int monto = Integer.parseInt(txtMontoGastoFijo.getText());
            if(monto<1){
                lblMontoGastoFijo.setText("El monto debe ser mayo a cero");
                txtMontoGastoFijo.selectAll();
                txtMontoGastoFijo.requestFocus();
                return false;
            }
            
        } catch (NumberFormatException e) {
        lblMontoGastoFijo.setText("El monto debe ser un numero entero");
                txtMontoGastoFijo.selectAll();
                txtMontoGastoFijo.requestFocus();
                return false;
                
        }
        return true;        
    } 
    
    @FXML //Agregar un nuevo Gasto Fijo
    private void AgregarGastoFijo(ActionEvent event) {
        if(validarGastoFijo()){
            String detalle;
            if(cmbDetalleGastoFijo.getValue().equalsIgnoreCase("otro")){
                detalle=txtDetalleGastoFijo.getText();
            }else detalle=cmbDetalleGastoFijo.getValue();
            gasto gasto = new gasto(
                    Integer.parseInt(txtA??oGastoFijo.getText()), 
                    cmbMesGastoFijo.getValue(),
                    cmbMiembroGastoFijo.getValue().getId(), 
                    detalle, 
                    Integer.parseInt(txtMontoGastoFijo.getText())
            );
            gfr.save(gasto);
            cargar();
            lblErrorAgregarGastoFijo.setText("Gasto Agregado.");
        }else lblErrorAgregarGastoFijo.setText("No pudo Agregarse.");
        
    }
   
    @FXML// Modificar un gasto fijo
    private void UpdateGastoFijo(ActionEvent event) {
        //Compruebo que haya una selecci??n hecha
        if(idGastoFijo==0){
            lblErrorUpdateGastoFijo.setText("Seleccionar Gasto");
            tblGastoFijo.requestFocus();
            return;
        }
        //Compruebo que los datos sean correctos y asigno el cambio
        if(validarGastoFijo()){
            String detalle;
            if(cmbDetalleGastoFijo.getValue().equalsIgnoreCase("otro")){
                detalle=txtDetalleGastoFijo.getText();
            }else detalle=cmbDetalleGastoFijo.getValue();
            gasto gasto = new gasto(
                    idGastoFijo,
                    Integer.parseInt(txtA??oGastoFijo.getText()), 
                    cmbMesGastoFijo.getValue(),
                    cmbMiembroGastoFijo.getValue().getId(), 
                    detalle, 
                    Integer.parseInt(txtMontoGastoFijo.getText())
            );
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Modificar Gasto");
                    alert.setContentText("??Esta segure de modificar el gasto?");
                    if(alert.showAndWait().get()==ButtonType.OK){
                        gfr.update(gasto);
                        cargar();
                        lblErrorUpdateGastoFijo.setText("Gasto modificado.");
                    }
        }else lblErrorUpdateGastoFijo.setText("Problemas al modificar gasto");
        
    }
    
    @FXML //Tomo una seleccion de la tabla de gastos Fijos
    private void SeleccionarGastoFijo(MouseEvent event) {
        if(tblGastoFijo.getSelectionModel().getSelectedItem()==null)return;
        gasto gasto = new gasto(
                tblGastoFijo.getSelectionModel().getSelectedItem().getId(),
                tblGastoFijo.getSelectionModel().getSelectedItem().getA??o(),
                tblGastoFijo.getSelectionModel().getSelectedItem().getMes(),
                tblGastoFijo.getSelectionModel().getSelectedItem().getIdPersona(),
                tblGastoFijo.getSelectionModel().getSelectedItem().getDetalle(),
                tblGastoFijo.getSelectionModel().getSelectedItem().getMonto()
        );
        txtA??oGastoFijo.setText(Integer.toString(gasto.getA??o()));
        cmbMesGastoFijo.getSelectionModel().select(gasto.getMes());
        cmbMiembroGastoFijo.getSelectionModel().select(pr.getById(gasto.getIdPersona()));
        cmbDetalleGastoFijo.getSelectionModel().select(gasto.getDetalle());
        txtMontoGastoFijo.setText(Integer.toString(gasto.getMonto()));
        idGastoFijo=gasto.getId();
    }
    
    @FXML //Eliminar un gasto Fijo
    private void EliminarGastoFijo(ActionEvent event) {
        if(tblGastoFijo.getSelectionModel().getSelectedItem()==null){
            lblErrorDeleteGastoFijo.setText("Seleccione un gasto a eliminar");
            return;
        }
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Eliminar Gasto");
        alert.setContentText("??Esta segure que desea eliminar el gasto \n" + 
                tblGastoFijo.getSelectionModel().getSelectedItem().toString());
        if(alert.showAndWait().get()==ButtonType.OK){
            gfr.remove(tblGastoFijo.getSelectionModel().getSelectedItem());
            cargar();
            lblErrorDeleteGastoFijo.setText("Gasto eliminado.");
        }
    }
    
    
    @FXML //Realizo la carga del cmb de filtro para simplificar busqueda
    private void cmbFiltroGastoFijoSeleccion(ActionEvent event) {
        switch(cmbFiltroGastoFijo.getSelectionModel().getSelectedItem()){
            case "Filtro":      cmbTipoBusquedaGastoFijo.getItems().clear();
                                cmbTipoBusquedaGastoFijoDos.getItems().clear();
                                cmbTipoBusquedaGastoFijo.setOpacity(0);
                                cmbTipoBusquedaGastoFijoDos.setOpacity(0);
                                break;
            case "Miembro":     cmbTipoBusquedaGastoFijo.getItems().clear();
                                cmbTipoBusquedaGastoFijo.getItems().addAll(pr.getAll());
                                cmbTipoBusquedaGastoFijo.getSelectionModel().selectFirst();
                                cmbTipoBusquedaGastoFijoDos.getItems().clear();
                                cmbTipoBusquedaGastoFijo.setOpacity(1);
                                cmbTipoBusquedaGastoFijoDos.setOpacity(0);
                                break;
            case "Mes":         cmbTipoBusquedaGastoFijo.getItems().clear();
                                cmbTipoBusquedaGastoFijo.getItems().addAll(listaMes);
                                cmbTipoBusquedaGastoFijo.getSelectionModel().selectFirst();
                                cmbTipoBusquedaGastoFijoDos.getItems().clear();
                                cmbTipoBusquedaGastoFijo.setOpacity(1);
                                cmbTipoBusquedaGastoFijoDos.setOpacity(0);
                                break;
            case "A??o":         cmbTipoBusquedaGastoFijo.getItems().clear();
                                cmbTipoBusquedaGastoFijo.getItems().addAll(gfr.getA??os());
                                cmbTipoBusquedaGastoFijo.getSelectionModel().selectFirst();
                                cmbTipoBusquedaGastoFijoDos.getItems().clear();
                                cmbTipoBusquedaGastoFijo.setOpacity(1);
                                cmbTipoBusquedaGastoFijoDos.setOpacity(0);
                                break;
            case "Mes y A??o":   cmbTipoBusquedaGastoFijo.getItems().clear();
                                cmbTipoBusquedaGastoFijo.getItems().addAll(listaMes);
                                cmbTipoBusquedaGastoFijo.getSelectionModel().selectFirst();
                                cmbTipoBusquedaGastoFijoDos.getItems().clear();
                                cmbTipoBusquedaGastoFijoDos.getItems().addAll(gfr.getA??os());
                                cmbTipoBusquedaGastoFijoDos.getSelectionModel().selectFirst();
                                cmbTipoBusquedaGastoFijo.setOpacity(1);
                                cmbTipoBusquedaGastoFijoDos.setOpacity(1);
                                break;
            case "Detalle":     cmbTipoBusquedaGastoFijo.getItems().clear();
                                cmbTipoBusquedaGastoFijo.getItems().addAll(gfr.getDetalles());
                                cmbTipoBusquedaGastoFijo.getSelectionModel().selectFirst();
                                cmbTipoBusquedaGastoFijoDos.getItems().clear();
                                cmbTipoBusquedaGastoFijo.setOpacity(1);
                                cmbTipoBusquedaGastoFijoDos.setOpacity(0);
                                break;
        }
    }
    
    @FXML //Realizar una busqueda dentro de los gastos fijos
    private void BuscarGastoFijo(ActionEvent event) {
        switch(cmbFiltroGastoFijo.getSelectionModel().getSelectedItem()){
            case "Filtro":      lblErrorBusquedaGastoFijo.setText("Seleccione un filtro.");
                                break;
            case "Miembro":     lblErrorBusquedaGastoFijo.setText("");
                                new TableFx().cargar(
                                        tblGastoFijo, 
                                        gfr.getByPersona((persona)cmbTipoBusquedaGastoFijo.getValue())
                                );
                                break;
            case "Mes":         lblErrorBusquedaGastoFijo.setText("");
                                new TableFx().cargar(
                                        tblGastoFijo, 
                                        gfr.getByMes((Meses)cmbTipoBusquedaGastoFijo.getValue())
                                );
                                break;
            case "A??o":         lblErrorBusquedaGastoFijo.setText("");
                                new TableFx().cargar(
                                        tblGastoFijo, 
                                        gfr.getByA??o(Integer.parseInt(cmbTipoBusquedaGastoFijo.getValue().toString()))
                                );
                                break;
            case "Mes y A??o":   lblErrorBusquedaGastoFijo.setText("");
                                new TableFx().cargar(tblGastoFijo,
                                        gfr.getByMesesA??o(
                                                Integer.parseInt(cmbTipoBusquedaGastoFijoDos.getValue()),
                                                (Meses)cmbTipoBusquedaGastoFijo.getValue()
                                        ));
                                break;
            case "Detalle":     lblErrorBusquedaGastoFijo.setText("");
                                new TableFx().cargar(
                                        tblGastoFijo, 
                                        gfr.getByDetalle(cmbTipoBusquedaGastoFijo.getValue().toString()
                                        ));
                                break;
        }
    }

    /**
     * Estos son los eventos de la pesta??a Gasto
     * @param event 
     */
    
    @FXML //Controlo la capacidad del campo de texto Detalle de Gasto
    private void OtroDetalleGasto(ActionEvent event) {
    if (cmbDetalleGasto.getValue().equalsIgnoreCase("Otro")){
            txtDetalleGasto.setOpacity(1);
            txtDetalleGasto.requestFocus();
        } else txtDetalleGasto.setOpacity(0);
    }
    
    /**
     * Sirve para corroborar que el gasto fijo tenga los datos necesarios.
     * @return 
     */
    private boolean validarGasto(){
        //Validar A??o
        try {
            int a??o= Integer.parseInt(txtA??oGasto.getText());
            if(a??o<2013 || a??o>calendario.get(Calendar.YEAR)){
                lblA??oGasto.setText("El a??o esta fuera de rango.");
                txtA??oGasto.selectAll();
                txtA??oGasto.requestFocus();
                return false;
            }
        } catch (NumberFormatException e) {
            lblA??oGasto.setText("El a??o debe ser un n??mero entero");
            txtA??oGasto.selectAll();
            txtA??oGasto.requestFocus();
        }
        //validar detalle
        if (cmbDetalleGasto.getSelectionModel().getSelectedItem().equalsIgnoreCase("Otro") &&
                txtDetalleGasto.getText().equals("")){
            lblDetalleGasto.setText("Asigne el nuevo detalle.");
            txtDetalleGasto.requestFocus();
            return false;
        }
        //Validar Monto
        try {
            int monto = Integer.parseInt(txtMontoGasto.getText());
            if(monto<1){
                lblMontoGasto.setText("El monto debe ser mayo a cero");
                txtMontoGasto.selectAll();
                txtMontoGasto.requestFocus();
                return false;
            }
            
        } catch (NumberFormatException e) {
        lblMontoGasto.setText("El monto debe ser un numero entero");
                txtMontoGasto.selectAll();
                txtMontoGasto.requestFocus();
                return false;
                
        }
        return true;        
    } 
    
    @FXML //Agregar un nuevo gasto
    private void AgregarGasto(ActionEvent event) {
    if(validarGasto()){
        String detalle;
        if(cmbDetalleGasto.getValue().equalsIgnoreCase("Otro")){
            detalle = txtDetalleGasto.getText();
        } else detalle=cmbDetalleGasto.getValue();
        gasto gasto = new gasto(
                Integer.parseInt(txtA??oGasto.getText()), 
                cmbMesGasto.getValue(), 
                cmbMiembroGasto.getValue().getId(), 
                detalle, 
                Integer.parseInt(txtMontoGasto.getText())
        );
        gr.save(gasto);
        cargar();
        lblErrorAgregarGasto.setText("Gasto agregado");
    } else lblErrorAgregarGasto.setText("Error al agregar gasto");
    }

    @FXML //Modificar un gasto
    private void UpdateGasto(ActionEvent event) {
     //Compruebo que haya una selecci??n hecha
        if(idGasto==0){
            lblErrorUpdateGasto.setText("Seleccionar Gasto");
            tblGasto.requestFocus();
            return;
        }
        //Compruebo que los datos sean correctos y asigno el cambio
        if(validarGasto()){
            String detalle;
            if(cmbDetalleGasto.getValue().equalsIgnoreCase("otro")){
                detalle=txtDetalleGasto.getText();
            }else detalle=cmbDetalleGasto.getValue();
            gasto gasto = new gasto(
                    idGasto,
                    Integer.parseInt(txtA??oGasto.getText()), 
                    cmbMesGasto.getValue(),
                    cmbMiembroGasto.getValue().getId(), 
                    detalle, 
                    Integer.parseInt(txtMontoGasto.getText())
            );
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText("Modificar Gasto");
                    alert.setContentText("??Esta segure de modificar el gasto?");
                    if(alert.showAndWait().get()==ButtonType.OK){
                        gr.update(gasto);
                        cargar();
                        lblErrorUpdateGasto.setText("Gasto modificado.");
                    }
        }else lblErrorUpdateGasto.setText("Problemas al modificar gasto");
        
    }
    
    @FXML //selecciona un gasto dentro de la tabla
    private void SeleccionarGasto(MouseEvent event) {
    if(tblGasto.getSelectionModel().getSelectedItem()==null)return;
        gasto gasto = new gasto(
                tblGasto.getSelectionModel().getSelectedItem().getId(),
                tblGasto.getSelectionModel().getSelectedItem().getA??o(),
                tblGasto.getSelectionModel().getSelectedItem().getMes(),
                tblGasto.getSelectionModel().getSelectedItem().getIdPersona(),
                tblGasto.getSelectionModel().getSelectedItem().getDetalle(),
                tblGasto.getSelectionModel().getSelectedItem().getMonto()
        );
        txtA??oGasto.setText(Integer.toString(gasto.getA??o()));
        cmbMesGasto.getSelectionModel().select(gasto.getMes());
        cmbMiembroGasto.getSelectionModel().select(pr.getById(gasto.getIdPersona()));
        cmbDetalleGasto.getSelectionModel().select(gasto.getDetalle());
        txtMontoGasto.setText(Integer.toString(gasto.getMonto()));
        idGasto=gasto.getId();
    }
    
    @FXML //Eliminar un Gasto
    private void EliminarGasto(ActionEvent event) {
    if(tblGasto.getSelectionModel().getSelectedItem()==null){
            lblErrorDeleteGasto.setText("Seleccione un gasto a eliminar");
            return;
        }
        Alert alert = new Alert (Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Eliminar Gasto");
        alert.setContentText("??Esta segure que desea eliminar el gasto \n" + 
                tblGasto.getSelectionModel().getSelectedItem().toString());
        if(alert.showAndWait().get()==ButtonType.OK){
            gr.remove(tblGasto.getSelectionModel().getSelectedItem());
            cargar();
            lblErrorDeleteGasto.setText("Gasto eliminado.");
        }
    }

    @FXML //Realizo la carga de los CMB de filtro para simplificar la busqueda
    private void cmbFiltroGastoSeleccion(ActionEvent event) {
        switch(cmbFiltroGasto.getSelectionModel().getSelectedItem()){
            case "Filtro":      cmbTipoBusquedaGasto.getItems().clear();
                                cmbTipoBusquedaGastoDos.getItems().clear();
                                cmbTipoBusquedaGasto.setOpacity(0);
                                cmbTipoBusquedaGastoDos.setOpacity(0);
                                break;
            case "Miembro":     cmbTipoBusquedaGasto.getItems().clear();
                                cmbTipoBusquedaGasto.getItems().addAll(pr.getAll());
                                cmbTipoBusquedaGasto.getSelectionModel().selectFirst();
                                cmbTipoBusquedaGastoDos.getItems().clear();
                                cmbTipoBusquedaGasto.setOpacity(1);
                                cmbTipoBusquedaGastoDos.setOpacity(0);
                                break;
            case "Mes":         cmbTipoBusquedaGasto.getItems().clear();
                                cmbTipoBusquedaGasto.getItems().addAll(listaMes);
                                cmbTipoBusquedaGasto.getSelectionModel().selectFirst();
                                cmbTipoBusquedaGastoDos.getItems().clear();
                                cmbTipoBusquedaGasto.setOpacity(1);
                                cmbTipoBusquedaGastoDos.setOpacity(0);
                                break;
            case "A??o":         cmbTipoBusquedaGasto.getItems().clear();
                                cmbTipoBusquedaGasto.getItems().addAll(gr.getA??os());
                                cmbTipoBusquedaGasto.getSelectionModel().selectFirst();
                                cmbTipoBusquedaGastoDos.getItems().clear();
                                cmbTipoBusquedaGasto.setOpacity(1);
                                cmbTipoBusquedaGastoDos.setOpacity(0);
                                break;
            case "Mes y A??o":   cmbTipoBusquedaGasto.getItems().clear();
                                cmbTipoBusquedaGasto.getItems().addAll(listaMes);
                                cmbTipoBusquedaGasto.getSelectionModel().selectFirst();
                                cmbTipoBusquedaGastoDos.getItems().clear();
                                cmbTipoBusquedaGastoDos.getItems().addAll(gr.getA??os());
                                cmbTipoBusquedaGastoDos.getSelectionModel().selectFirst();
                                cmbTipoBusquedaGasto.setOpacity(1);
                                cmbTipoBusquedaGastoDos.setOpacity(1);
                                break;
            case "Detalle":     cmbTipoBusquedaGasto.getItems().clear();
                                cmbTipoBusquedaGasto.getItems().addAll(gr.getDetalles());
                                cmbTipoBusquedaGasto.getSelectionModel().selectFirst();
                                cmbTipoBusquedaGastoDos.getItems().clear();
                                cmbTipoBusquedaGasto.setOpacity(1);
                                cmbTipoBusquedaGastoDos.setOpacity(0);
                                break;
        }
    }    

    @FXML //Buscar un gasto en la tabla
    private void BuscarGasto(ActionEvent event) {
    switch(cmbFiltroGasto.getSelectionModel().getSelectedItem()){
            case "Filtro":      lblErrorBusquedaGasto.setText("Seleccione un filtro.");
                                break;
            case "Miembro":     lblErrorBusquedaGasto.setText("");
                                new TableFx().cargar(
                                        tblGasto, 
                                        gr.getByPersona((persona)cmbTipoBusquedaGasto.getValue())
                                );
                                break;
            case "Mes":         lblErrorBusquedaGasto.setText("");
                                new TableFx().cargar(
                                        tblGasto, 
                                        gr.getByMes((Meses)cmbTipoBusquedaGasto.getValue())
                                );
                                break;
            case "A??o":         lblErrorBusquedaGasto.setText("");
                                new TableFx().cargar(
                                        tblGasto, 
                                        gr.getByA??o(Integer.parseInt(cmbTipoBusquedaGasto.getValue().toString()))
                                );
                                break;
            case "Mes y A??o":   lblErrorBusquedaGasto.setText("");
                                new TableFx().cargar(tblGasto,
                                        gr.getByMesesA??o(
                                                Integer.parseInt(cmbTipoBusquedaGastoDos.getValue()),
                                                (Meses)cmbTipoBusquedaGasto.getValue()
                                        ));
                                break;
            case "Detalle":     lblErrorBusquedaGasto.setText("");
                                new TableFx().cargar(
                                        tblGasto, 
                                        gr.getByDetalle(cmbTipoBusquedaGasto.getValue().toString()
                                        ));
                                break;
        }
    }

   
    /**
     * Estos son los eventos de la pesta??a Analisis
     * @param event 
     */
    @FXML //Aplico un filtro a la muestra de  analisis
    private void btnFiltrar(ActionEvent event) {
        if(cmbTipoFiltroAnalisis.getValue().equalsIgnoreCase("Seleccione")){
            lblErrorAnalisis.setText("Seleccione un filtro");
            return;
        } else filtroAnalisis = true;
        switch(cmbTipoFiltroAnalisis.getValue()){
            case "Miembro": 
                tipoFiltroAnalisis ="Miembro";
                persona p1 = (persona)cmbFiltroAnalisis.getValue();
                valorFiltroAnalisis= Integer.toString(p1.getId());
                
        //Cargo los txt de gasto
        txtTotal.setText((Integer.toString(gr.getTotalPersona(Integer.parseInt(valorFiltroAnalisis)))));
        txtTotalA??oActual.setText(Integer.toString(gr.getTotalByPersonaA??o(Integer.parseInt(valorFiltroAnalisis),calendario.get(Calendar.YEAR))));
        txtTotalA??o.setText(Integer.toString(gr.getTotalByPersonaA??o(Integer.parseInt(valorFiltroAnalisis),Integer.parseInt(cmbOtroA??o.getValue()))));
        txtTotalMesActual.setText(Integer.toString(gr.getTotalByPersonaMesesA??o(Integer.parseInt(valorFiltroAnalisis), calendario.get(Calendar.YEAR),listaMes.get(calendario.get(Calendar.MONTH)))));
        txtTotalMes.setText(Integer.toString(gr.getTotalByPersonaMesesA??o(Integer.parseInt(valorFiltroAnalisis),Integer.parseInt(cmbOtroMesA??o.getValue()),cmbOtroMes.getValue())));
        
        //Cargo los txt de gasto fijo
        txtTotalGF.setText((Integer.toString(gfr.getTotalPersona(Integer.parseInt(valorFiltroAnalisis)))));
        txtTotalA??oActualGF.setText(Integer.toString(gfr.getTotalByPersonaA??o(Integer.parseInt(valorFiltroAnalisis),calendario.get(Calendar.YEAR))));
        txtTotalA??oGF.setText(Integer.toString(gfr.getTotalByPersonaA??o(Integer.parseInt(valorFiltroAnalisis),Integer.parseInt(cmbOtroA??oGF.getValue()))));
        txtTotalMesActualGF.setText(Integer.toString(gfr.getTotalByPersonaMesesA??o(Integer.parseInt(valorFiltroAnalisis), calendario.get(Calendar.YEAR),listaMes.get(calendario.get(Calendar.MONTH)))));
        txtTotalMesGF.setText(Integer.toString(gfr.getTotalByPersonaMesesA??o(Integer.parseInt(valorFiltroAnalisis), Integer.parseInt(cmbOtroMesA??oGF.getValue()),cmbOtroMesGF.getValue())));
        
        break;
            case "Detalle": 
                tipoFiltroAnalisis = "Detalle";
                valorFiltroAnalisis = (String)cmbFiltroAnalisis.getValue();
                
        //Cargo los txt de gasto
        txtTotal.setText((Integer.toString(gr.getTotalByDetalle(valorFiltroAnalisis))));
        txtTotalA??oActual.setText(Integer.toString(gr.getTotalByDetalleA??o(valorFiltroAnalisis, calendario.get(Calendar.YEAR))));
        txtTotalA??o.setText(Integer.toString(gr.getTotalByDetalleA??o(valorFiltroAnalisis, Integer.parseInt(cmbOtroA??o.getValue()))));
        txtTotalMesActual.setText(Integer.toString(gr.getTotalByDetalleMesesA??o(valorFiltroAnalisis, listaMes.get(calendario.get(Calendar.MONTH)), calendario.get(Calendar.YEAR))));
        txtTotalMes.setText(Integer.toString(gr.getTotalByDetalleMesesA??o(valorFiltroAnalisis, listaMes.get(calendario.get(Calendar.MONTH)), calendario.get(Calendar.YEAR))));
        
        //Cargo los txt de gasto fijo
        txtTotalGF.setText((Integer.toString(gfr.getTotalByDetalle(valorFiltroAnalisis))));
        txtTotalA??oActualGF.setText(Integer.toString(gfr.getTotalByDetalleA??o(valorFiltroAnalisis, calendario.get(Calendar.YEAR))));
        txtTotalA??oGF.setText(Integer.toString(gfr.getTotalByDetalleA??o(valorFiltroAnalisis, Integer.parseInt(cmbOtroA??oGF.getValue()))));
        txtTotalMesActualGF.setText(Integer.toString(gfr.getTotalByDetalleMesesA??o(valorFiltroAnalisis,listaMes.get(calendario.get(Calendar.MONTH)), calendario.get(Calendar.YEAR))));
        txtTotalMesGF.setText(Integer.toString(gfr.getTotalByDetalleMesesA??o(valorFiltroAnalisis,listaMes.get(calendario.get(Calendar.MONTH)), calendario.get(Calendar.YEAR))));
        break;
        }
    }


    @FXML //Limpio todo filtro hecho
    private void btnLimpiar(ActionEvent event) {
        cargar();
    }

    @FXML//Cambia el tipo de filtro a seleccionar
    private void cmbFiltroAnalisis(ActionEvent event) {
        if(!(cmbTipoFiltroAnalisis.getValue().equalsIgnoreCase("seleccione"))){
            cmbFiltroAnalisis.setOpacity(1);
        }else cmbFiltroAnalisis.setOpacity(0);
        switch(cmbTipoFiltroAnalisis.getSelectionModel().getSelectedItem()){
            case "Seleccione": cmbFiltroAnalisis.getItems().clear();
                               break;
            case "Miembro":    cmbFiltroAnalisis.getItems().clear();
                               cmbFiltroAnalisis.getItems().addAll(pr.getAll());
                               break;
            case "Detalle":    cmbFiltroAnalisis.getItems().clear();
                               for(String s: gr.getDetalles()){
                                   if(!(s.equals("Otro"))){
                                   cmbFiltroAnalisis.getItems().add(s);
                               }}
                               gfr.getDetalles().stream().filter((s) -> (!(s.equals("Otro")))).forEachOrdered((s) -> {
                                   cmbFiltroAnalisis.getItems().add(s);
        });
                               break;
        }
    }

    @FXML//Cambia el valor de filtro de a??o de gasto
    private void cmbOtroA??o(ActionEvent event) {
        int total=0;
        if(filtroAnalisis){
            switch(tipoFiltroAnalisis){
                case "Miembro": total = gr.getTotalByPersonaA??o(
                        Integer.parseInt(valorFiltroAnalisis), Integer.parseInt(cmbOtroA??o.getValue()
                                ));
                                break;
                case "Detalle": total = gr.getTotalByDetalleA??o
                            (valorFiltroAnalisis, Integer.parseInt(cmbOtroA??o.getValue()
                        ));
                                break;
            }
        } else total = gr.getTotalByA??o(Integer.parseInt(cmbOtroA??o.getValue()));
        txtTotalA??o.setText(Integer.toString(total));
    }

    @FXML//Cambia el valor del filtro de mes de gasto
    private void cmbOtroMes(ActionEvent event) {
        int total=0;
        if(filtroAnalisis){
            switch(tipoFiltroAnalisis){
                case "Miembro": total = gr.getTotalByPersonaMesesA??o(
                        Integer.parseInt(valorFiltroAnalisis), Integer.parseInt(cmbOtroMesA??o.getValue()), cmbOtroMes.getValue());
                                break;
                case "Detalle": total = gr.getTotalByDetalleMesesA??o(valorFiltroAnalisis, cmbOtroMes.getValue(), Integer.parseInt(cmbOtroMesA??o.getValue()));
                                break;
            }
        } else total = gr.getTotalByMesesA??o(Integer.parseInt(cmbOtroMesA??o.getValue()),cmbOtroMes.getValue());
        txtTotalMes.setText(Integer.toString(total));
    }

    @FXML//Cambia el valor del filtro de a??o con mes de gasto
    private void cmbOtroMesA??o(ActionEvent event) {
        int total=0;
        if(filtroAnalisis){
            switch(tipoFiltroAnalisis){
                case "Miembro": total = gr.getTotalByPersonaMesesA??o(
                        Integer.parseInt(valorFiltroAnalisis), Integer.parseInt(cmbOtroMesA??o.getValue()), cmbOtroMes.getValue());
                                break;
                case "Detalle": total = gr.getTotalByDetalleMesesA??o(valorFiltroAnalisis, cmbOtroMes.getValue(), Integer.parseInt(cmbOtroMesA??o.getValue()));
                                break;
            }
        } else total = gr.getTotalByMesesA??o(Integer.parseInt(cmbOtroMesA??o.getValue()),cmbOtroMes.getValue());
        txtTotalMes.setText(Integer.toString(total));
    }

    @FXML//Cambia el valor de filtro de a??o de gasto Fijo
    private void cmbOtroA??oGF(ActionEvent event) {
        int total=0;
        if(filtroAnalisis){
            switch(tipoFiltroAnalisis){
                case "Miembro": total = gfr.getTotalByPersonaA??o(
                        Integer.parseInt(valorFiltroAnalisis), Integer.parseInt(cmbOtroA??oGF.getValue()
                                ));
                                break;
                case "Detalle": total = gfr.getTotalByDetalleA??o
                            (valorFiltroAnalisis, Integer.parseInt(cmbOtroA??oGF.getValue()
                        ));
                                break;
            }
        } else total = gfr.getTotalByA??o(Integer.parseInt(cmbOtroA??oGF.getValue()));
        txtTotalA??oGF.setText(Integer.toString(total));
    }

    @FXML//Cambia el valor de filtro de mes de gasto Fijo
    private void cmbOtroMesGF(ActionEvent event) {
        int total=0;
        if(filtroAnalisis){
            switch(tipoFiltroAnalisis){
                case "Miembro": total = gfr.getTotalByPersonaMesesA??o(
                        Integer.parseInt(valorFiltroAnalisis), Integer.parseInt(cmbOtroMesA??oGF.getValue()), cmbOtroMesGF.getValue());
                                break;
                case "Detalle": total = gfr.getTotalByDetalleMesesA??o(valorFiltroAnalisis, cmbOtroMesGF.getValue(), Integer.parseInt(cmbOtroMesA??oGF.getValue()));
                                break;
            }
        } else total = gfr.getTotalByMesesA??o(Integer.parseInt(cmbOtroMesA??oGF.getValue()),cmbOtroMesGF.getValue());
        txtTotalMesGF.setText(Integer.toString(total));
    }

    @FXML//Cambia el valor de filtro de a??o con mes de gasto fijo
    private void cmbOtroMesA??oGF(ActionEvent event) {
        int total=0;
        if(filtroAnalisis){
            switch(tipoFiltroAnalisis){
                case "Miembro": total = gfr.getTotalByPersonaMesesA??o(
                        Integer.parseInt(valorFiltroAnalisis), Integer.parseInt(cmbOtroMesA??oGF.getValue()), cmbOtroMesGF.getValue());
                                break;
                case "Detalle": total = gfr.getTotalByDetalleMesesA??o(valorFiltroAnalisis, cmbOtroMesGF.getValue(), Integer.parseInt(cmbOtroMesA??oGF.getValue()));
                                break;
            }
        } else total = gfr.getTotalByMesesA??o(Integer.parseInt(cmbOtroMesA??oGF.getValue()),cmbOtroMesGF.getValue());
        txtTotalMesGF.setText(Integer.toString(total));
    }

  /**
   * Estos son los metodos de la pesta??a deuda
   * @param event 
   */
    @FXML//Efectua el pago de una deuda
    private void btnPagarDeuda(ActionEvent event) {
        persona pagando = cmbDeudaMiembro1.getValue();
        persona cobrando = cmbDeudaMiembro2.getValue();
        if(pagando.equals(cobrando)){
            lblErrorDeuda.setText("No puede ser mismo miembro");
            return;
        }
        List <gasto> lista;
        int monto = Integer.parseInt(txtDeudaMonto.getText());
        if(monto>gr.getTotalPersona(cobrando)) {
            lblErrorDeuda.setText("El monto es muy grande");
            return;
        }
        if(cmbDeudaGasto.getValue().equalsIgnoreCase("Corriente")){
                lista = gr.getByPersona(cobrando);
                for(gasto g: lista){
                    if(g.getMonto()>monto){
                        gr.update(new gasto(
                                g.getId(),
                                g.getA??o(),
                                g.getMes(),
                                g.getIdPersona(),
                                g.getDetalle(),
                                (g.getMonto()-monto)
                        ));
                        gr.save(new gasto(
                                g.getA??o(),
                                g.getMes(),
                                pagando.getId(),
                                g.getDetalle(),
                                monto
                        ));
                        monto = 0;
                        break;
                    } else if(g.getMonto()==monto){
                        gr.update(new gasto(
                                g.getId(),
                                g.getA??o(),
                                g.getMes(),
                                pagando.getId(),
                                g.getDetalle(),
                                monto));
                                monto=0;
                        break;
                    } else if(g.getMonto()<monto){
                        gr.update(new gasto(
                                g.getId(),
                                g.getA??o(),
                                g.getMes(),
                                pagando.getId(),
                                g.getDetalle(),
                                monto));
                        monto-= g.getMonto();
                    }
                }
        } else {
            lista = gfr.getByPersona(cobrando);
            for(gasto g: lista){
                    if(g.getMonto()>monto){
                        gfr.update(new gasto(
                                g.getId(),
                                g.getA??o(),
                                g.getMes(),
                                g.getIdPersona(),
                                g.getDetalle(),
                                (g.getMonto()-monto)
                        ));
                        gfr.save(new gasto(
                                g.getA??o(),
                                g.getMes(),
                                pagando.getId(),
                                g.getDetalle(),
                                monto
                        ));
                        monto = 0;
                        break;
                    } else if(g.getMonto()==monto){
                        gfr.update(new gasto(
                                g.getId(),
                                g.getA??o(),
                                g.getMes(),
                                pagando.getId(),
                                g.getDetalle(),
                                monto));
                                monto=0;
                        break;
                    } else if(g.getMonto()<monto){
                        gfr.update(new gasto(
                                g.getId(),
                                g.getA??o(),
                                g.getMes(),
                                pagando.getId(),
                                g.getDetalle(),
                                monto));
                        monto-= g.getMonto();
                    }
                }
        }
        cargar();        
    }
}
