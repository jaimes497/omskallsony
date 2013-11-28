package co.com.kallsony.imagen;

import java.io.IOException;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

@Name("archivoLogo")
@Scope(ScopeType.CONVERSATION)
public class ArchivoLogo extends Archivos {
	
	private UploadItem	ultimoArchivoDescargado;

	public void listener(UploadEvent event) throws IOException
	{
		ultimoArchivoDescargado = event.getUploadItem();

		UploadItem item = ultimoArchivoDescargado;
		System.out.println("-----------Archivo cargado------------");
		System.out.println("# Archivos:" + event.getUploadItems().size());
		System.out.println("Nombre:" + item.getFileName());
		System.out.println("Es temporal:" + item.isTempFile());
		System.out.println("Tamaño:" + item.getFileSize());
		System.out.println("Tipo:" + item.getContentType());
		System.out.println("Datos: " + item.getData());
	}
	
	public String guardar(String ruta, String nombre, String extension) throws IOException {
		try {
			super.setUltimoArchivoDescargado(ultimoArchivoDescargado);
			return super.guardarCopiaV2(ruta, nombre, extension);
		} catch (Exception e) {
			
			return null;
		}
	}

}
