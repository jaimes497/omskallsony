package co.com.kallsony.imagen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

/**
 * @author Lewis Clase que permite administrar los archivos de la aplicacion
 * 
 */
@Name("archivos")
@Scope(ScopeType.CONVERSATION)
public class Archivos
{

	@Logger
	private Log			log;

	@In
	StatusMessages		statusMessages;
	@In
	FacesContext		facesContext;
	@In
	FacesMessages		facesMessages;

	private UploadItem	ultimoArchivoDescargado;
	private List<File>	listaAdjuntos	= new ArrayList<File>();

	public void listener(UploadEvent event) throws IOException
	{
		ultimoArchivoDescargado = event.getUploadItem();

		UploadItem item = ultimoArchivoDescargado;
		log.info("-----------Archivo cargado------------");
		log.info("# Archivos:" + event.getUploadItems().size());
		log.info("Nombre:" + item.getFileName());
		log.info("Es temporal:" + item.isTempFile());
		log.info("Tamaño:" + item.getFileSize());
		log.info("Tipo:" + item.getContentType());
		log.info("Datos: " + item.getData());
	}

	/**
	 * permite hacer una copia de un archivo
	 * 
	 * @param ruta
	 * @param nombre
	 * @param extension
	 * @return String
	 * @throws IOException
	 */
	// add additional action methods

	@SuppressWarnings("resource")
	public String guardarCopiaV2(String ruta, String nombre, String extension) throws IOException
	{
		if (ultimoArchivoDescargado == null)
		{
			return null;
		}

		FileInputStream fis = null;
		FileOutputStream fos = null;
		File archivoDestino = null;

		try
		{// extension incluye el punto
			if (extension == null)
			{
				extension = getExtensionArchivo();
			}

			archivoDestino = new File(ruta, nombre + extension);

			if (!archivoDestino.exists())
			{
				archivoDestino.createNewFile();
			} else
			{
				archivoDestino.delete();
			}

			fos = new FileOutputStream(archivoDestino);

			if (ultimoArchivoDescargado.isTempFile())
			{
				File f = ultimoArchivoDescargado.getFile();
				fis = new FileInputStream(f);
				FileChannel in = fis.getChannel();
				FileChannel out = fos.getChannel();
				in.transferTo(0, in.size(), out);
				// copiaArchivo = null;
			} else
			{

				fos.write(ultimoArchivoDescargado.getData());
				fos.flush();
				fos.close();
			}
		} catch (ArrayIndexOutOfBoundsException e)
		{
			facesMessages.clear();
			facesMessages.add(Severity.ERROR, "Error: No se pudo crear el archivo en el servidor cod: 101");
			log.info("Ha ocurrido una ArrayIndexOutOfBoundsException: #0", e.getMessage());
			facesMessages.add(Severity.ERROR, "Ocurrio un error al cargar el archivo");
			return null;
		} catch (NullPointerException e)
		{
			facesMessages.clear();
			facesMessages.add(Severity.ERROR, "Error: No se pudo crear el archivo en el servidor cod: 102");
			log.info("Ha ocurrido una NullPointerException: #0", e.getMessage());
			return null;
		} catch (IOException e)
		{
			facesMessages.clear();
			facesMessages.add(Severity.ERROR, "Error: El directorio de destino no existe en el servidor");
			log.info("Ha ocurrido una IOException: #0", e.getMessage());
			return null;
		}

		return archivoDestino.getName();
	}

	@SuppressWarnings("resource")
	public String guardarCopia(String ruta, String nombre, String extension) throws IOException
	{
		if (ultimoArchivoDescargado == null)
		{
			return null;
		}

		FileInputStream fis = null;
		FileOutputStream fos = null;
		File archivoDestino = null;
		try
		{// extension incluye el punto
			if (extension == null)
			{
				extension = getExtensionArchivo();
			}
			archivoDestino = new File(ruta, nombre + extension);
			if (!archivoDestino.exists())
			{
				archivoDestino.createNewFile();
			} else
			{
				archivoDestino.delete();
			}
			fos = new FileOutputStream(archivoDestino);
			if (ultimoArchivoDescargado.isTempFile())
			{
				File f = ultimoArchivoDescargado.getFile();
				fis = new FileInputStream(f);
				FileChannel in = fis.getChannel();
				FileChannel out = fos.getChannel();
				in.transferTo(0, in.size(), out);
				// copiaArchivo = null;
			} else
			{
				fos.write(ultimoArchivoDescargado.getData());
			}

		} catch (ArrayIndexOutOfBoundsException arrayExc)
		{
			arrayExc.printStackTrace();
			return null;
		} catch (NullPointerException ex)
		{
			ex.printStackTrace();
			return null;
		}

		return archivoDestino.getName();
	}

	@SuppressWarnings("resource")
	public String guardarCopia(String ruta) throws IOException
	{

		if (ultimoArchivoDescargado == null)
		{
			return null;
		}
		String nombre = ultimoArchivoDescargado.getFileName();

		FileInputStream fis = null;
		FileOutputStream fos = null;
		File archivoDestino = null;
		try
		{// extension incluye el punto

			archivoDestino = new File(ruta, nombre);
			if (!archivoDestino.exists())
			{
				archivoDestino.createNewFile();
			} else
			{
				archivoDestino.delete();
			}
			fos = new FileOutputStream(archivoDestino);
			if (ultimoArchivoDescargado.isTempFile())
			{
				File f = ultimoArchivoDescargado.getFile();
				fis = new FileInputStream(f);
				FileChannel in = fis.getChannel();
				FileChannel out = fos.getChannel();
				in.transferTo(0, in.size(), out);
				// copiaArchivo = null;
			} else
			{
				fos.write(ultimoArchivoDescargado.getData());
			}

		} catch (ArrayIndexOutOfBoundsException arrayExc)
		{
			arrayExc.printStackTrace();
			return null;
		} catch (NullPointerException ex)
		{
			ex.printStackTrace();
			return null;
		}

		return archivoDestino.getName();
	}

	public String getExtensionArchivo()
	{
		String s = null;

		try
		{
			if (ultimoArchivoDescargado == null)
			{
				return null;
			}

			s = ultimoArchivoDescargado.getFileName().substring(ultimoArchivoDescargado.getFileName().lastIndexOf('.'));

		} catch (Exception e)
		{
			s = "";
		}

		return s;
	}

	public String nameFile(String fileName)
	{
		return fileName.substring(fileName.lastIndexOf(File.separator) + 1);
	}

	public UploadItem getUltimoArchivoDescargado()
	{
		return ultimoArchivoDescargado;
	}

	public void setUltimoArchivoDescargado(UploadItem ultimoArchivoDescargado)
	{
		this.ultimoArchivoDescargado = ultimoArchivoDescargado;
	}

	public void paint(OutputStream stream, Object object) throws IOException
	{
		if (ultimoArchivoDescargado == null || stream == null)
		{
			return;
		}
		FileInputStream in = null;
		try
		{
			if (!ultimoArchivoDescargado.isTempFile())
			{
				stream.write(ultimoArchivoDescargado.getData());
			} else
			{
				in = new FileInputStream(ultimoArchivoDescargado.getFile());
				byte[] b = new byte[in.available()];
				in.read(b);
				stream.write(b);
			}
		} finally
		{
			if (in != null)
			{
				in.close();
			}
		}
	}

	/**
	 * metodo que borra un archivo dependiendo de los parametros formales del
	 * metodo
	 * 
	 * @param ruta
	 * @param nombreArchivo
	 * @return true, si logra borrar el archivo
	 */
	public boolean borrarArchivo(String ruta, String nombreArchivo)
	{
		try
		{
			File archivoDestinoF;
			if (nombreArchivo == null)
			{
				archivoDestinoF = new File(ruta);
			} else
			{
				archivoDestinoF = new File(ruta, nombreArchivo);
			}

			if (archivoDestinoF.exists())
			{
				log.info("existe" + archivoDestinoF.exists());

				return archivoDestinoF.delete();
			}

			System.out.println("Archivo: " + archivoDestinoF.getAbsolutePath() + "  " + archivoDestinoF.getAbsoluteFile());
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Permite borrar un directorio dado una ruta
	 * 
	 * @param ruta
	 * @return true si logra borrar un directorio con la ruta
	 */
	public boolean borrarDirectorio(String ruta)
	{

		try
		{
			File directorio = new File(ruta);
			if (directorio.exists())
			{
				File[] file = directorio.listFiles();
				for (File f : file)
				{
					f.delete();
				}
				directorio.delete();

			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * Crea un directorio en base a una ruta dada
	 * 
	 * @param ruta
	 * @return true si es satisfactoria la creacion del directorio
	 */
	public boolean crearDirectorio(String ruta)
	{
		try
		{
			File archivoDestinoF = new File(ruta);
			System.out.println("Directorio " + archivoDestinoF.getAbsolutePath());
			if (!archivoDestinoF.exists())
			{
				return archivoDestinoF.mkdir();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public String descargarFileCorreo(String dirArchivo, String fileNameDisplay)
	{
		HttpServletResponse httpResponse = (HttpServletResponse) facesContext.getExternalContext().getResponse();

		File fFile = new File(dirArchivo);
		String stFileName = fileNameDisplay+".eml";

		httpResponse.setHeader("Content-Disposition", "attachment;filename=\"" + stFileName + "\"");

		// the content type set as excel
		httpResponse.setContentType("application/eml");

		System.out.println("ExportInspectionPlanToExcel: Set all return properties...");

		// Open an input stream to the file and post the file contents thru the
		// servlet output stream to the client m/c
		InputStream isStream = null;
		ServletOutputStream sosStream = null;
		try
		{

			// response.flushBuffer();
			isStream = new FileInputStream(fFile);
			sosStream = httpResponse.getOutputStream();
			int ibit = 256;
			while ((ibit) >= 0)
			{
				ibit = isStream.read();
				sosStream.write(ibit);
			}
			isStream.close();
			sosStream.flush();
			System.out.println("ExportInspectionPlanToExcel: response Complete, redirected...");

			httpResponse.flushBuffer();
			facesContext.responseComplete();
			facesContext.renderResponse();
			return "Success";
		} catch (IOException exp)
		{
			log.info("exception -" + exp.getStackTrace());
			exp.printStackTrace();
			return "Failed";
		}
	}
	

	public String descargarFileGeneral(String dirArchivo, String fileNameDisplay)
	{
		HttpServletResponse httpResponse = (HttpServletResponse) facesContext.getExternalContext().getResponse();

		File fFile = new File(dirArchivo);
		String extension = this.getExtensionArchivo(fFile.getName());
		log.info("extension" + extension);
		String stFileName = fileNameDisplay;

		httpResponse.setHeader("Content-Disposition", "attachment;filename=\"" + stFileName + "\"");

		// the content type set as excel
		httpResponse.setContentType("application/" + extension);

		System.out.println("ExportInspectionPlanToExcel: Set all return properties...");

		// Open an input stream to the file and post the file contents thru the
		// servlet output stream to the client m/c
		InputStream isStream = null;
		ServletOutputStream sosStream = null;
		try
		{

			// response.flushBuffer();
			isStream = new FileInputStream(fFile);
			sosStream = httpResponse.getOutputStream();
			int ibit = 256;
			while ((ibit) >= 0)
			{
				ibit = isStream.read();
				sosStream.write(ibit);
			}
			isStream.close();
			sosStream.flush();
			System.out.println("ExportInspectionPlanToExcel: response Complete, redirected...");

			httpResponse.flushBuffer();
			facesContext.responseComplete();
			facesContext.renderResponse();
			return "Success";
		} catch (IOException exp)
		{
			log.info("exception -" + exp.getStackTrace());
			exp.printStackTrace();
			return "Failed";
		}
	}

	public String descargarFileGeneralXls(String dirArchivo, String fileNameDisplay)
	{
		HttpServletResponse httpResponse = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		File fFile = new File(dirArchivo);
		String extension = "xls";
		String stFileName = fileNameDisplay;

		httpResponse.setHeader("Content-Disposition", "attachment;filename=\"" + stFileName + "\"");
		httpResponse.setContentType("application/" + extension);

		// Open an input stream to the file and post the file contents thru the
		// servlet output stream to the client m/c
		InputStream isStream = null;
		ServletOutputStream sosStream = null;

		try
		{
			// response.flushBuffer();
			isStream = new FileInputStream(fFile);
			sosStream = httpResponse.getOutputStream();
			int ibit = 256;

			while ((ibit) >= 0)
			{
				ibit = isStream.read();
				sosStream.write(ibit);
			}

			isStream.close();
			sosStream.flush();
			httpResponse.flushBuffer();
			facesContext.responseComplete();
			facesContext.renderResponse();
			return "Success";
		} catch (IOException exp)
		{
			log.info("exception -" + exp.getStackTrace());
			return "Failed";
		}
	}

	public String getExtensionArchivo(String fileName)
	{
		try
		{
			if (fileName == null)
			{
				return null;
			}

			log.info("file name" + fileName);
			return fileName.substring(fileName.lastIndexOf('.'));
		} catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}

	public List<File> getListaAdjuntos()
	{
		return listaAdjuntos;
	}

	public void setListaAdjuntos(List<File> listaAdjuntos)
	{
		this.listaAdjuntos = listaAdjuntos;
	}

}