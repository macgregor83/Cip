/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cip.util;

import es.cip.bussines.dao.model.EstatusProyecto;
import es.cip.view.Login;
import java.awt.Window;

/**
 *
 * @author iMac
 */
public class Cte {

    public static final String Persistence_Unit_Name = "CIPPU";

    /**
     * * encabezados de jTabbedPane de Menu Principal **
     */
    public static final String Seccion_Publica = "Sección Pública";
    public static final String Alta_Usuario = "Alta de Usuario";
    public static final String Avances_Proyecto = "Avances Proyecto";
    public static final String Registro_Proyecto = "Registro Proyecto";
    public static final String Estado_Proyecto = " Aprobar Proyecto";
    public static final String Archivo_Erroneo = "Archivo Invalido";

    /*  */
    public static final String Solo_Letras = "Este campo solo admite Letras";
    public static final String Pass = "Minimo 8 caracteres\n"
            + " Maximo 15\n"
            + " Al menos una letra mayúscula\n"
            + " Al menos una letra minucula\n"
            + " Al menos un dígito\n"
            + " No espacios en blanco\n"
            + " Al menos 1 caracter especial";
    public static final String Pass_Diferente = "Las Contraseñas son diferentes.";
    public static final String Tel_Erroneo = "El telefono el incorrecto";
    public static final String Correo_Erroneo = "Correo Erroneo";
    public static final String Campo_Vacio = "No se admite vacio";
    public static final String Solo_Numero = "Este campo solo admite Numeros";
    public static final String Falta_llenar_Campos = "Falta llenar campos";
    public static final String Usua_Rep = "Este usuario ya existe";
    public static final String No_Control_Rep = "Este Numero de control ya existe";
    public static final String No_Existe_Usuario = "Selecciona una persona";

    //Errores
    public static final String Error_BD = "Error en conexión a base de datos";
    public static final String Error_Abrir_PDF = "Error al abrir pdf";
    public static final String Error_Abrir_Pagina = "Error al abrir Pagina Web";

    public static final String Guardo_Correcto = "Se guardó correctamente.";
    ///** Estatus Del Proyecto**///
    //public static final Integer Estatus_Proyecto = 1;

    public static final String Proyecto_No_existe = "Este Proyecto no existe";
    public static final String Selecciona_Campos = "Selecciona algun Campo";
    public static final String No_aprueba = "Aun no se puede aprobar o ya esta aprobado";

    // id de tabla estatus registro
    public static Integer Estatus_Registro_Proyecto_F1 = 1;
    public static Integer Estatus_Registro_Proyecto_F2 = 2;
    public static final Integer Estatus_Proyecto_Por_Aprobacion = 3;
    public static Integer Estatus_Proyecto_Aprobado = 4;

    // id de tabla estatus fase
    public static final Integer Estatus_Face_registro = 1;
    public static final Integer Estatus_Face_Desarrollo = 2;
    public static final Integer Estatus_Face_Termino = 3;
        public static final String Fase_Incompleta="No se han a completado las fases ";
    //id de tabla estatus tipo de usuario
    public static final Integer Tipo_Alumno = 1;
    public static final Integer Tipo_Asesor = 2;
    public static final Integer Tipo_Admin = 3;

    //TITULOS DE PANTALLAS
    public static final String Titulo_JAsociaciònUsuario = "Recursos Humanos";
    public static final String Titulo_JFActividades = "Actualizaciones de la Actividad";
    public static final String Titulo_JFConvocatorias = "Convocatorias";
    public static final String Titulo_JFDatosAcademicos = "Datos Academicos";
    public static final String Titulo_JFEstadoProyecto = "Proyectos";
    public static final String Titulo_JFEstadosProyectos = "Proyectos";
    public static final String Titulo_JFInvitados = "Registro Proyectos";
    public static final String Titulo_JFPatentes = "Patente";
    public static final String Titulo_JFRegistroPersona = "Datos Personales";
    public static final String Titulo_JFases = "Metodologia/Cronograma";
    public static final String Titulo_JProyecto = "Datos Proyecto";
    public static final String Titulo_JRegistroProyecto = "Proyecto Datos Proyecto";
    public static final String Titulo_Login = "Login";

    //JFProyectoConvocatoria
    public static final String Selecciona_Solo_Uno = "Selecciona solo un registro de cada tabla.";
    
    //login
    public static final String Usuario_Pass_Erroneas="Usuaro o Contraseña Erronea";
    
    
    public static final String Mensaje_Espera_Apobar="Se realizó tu registro del proyecto, en espera de revisión y aprobación.";


}
