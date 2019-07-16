/**
 * 
 */
package pe.banca.empresa.dto;

/**
 * @author vector
 *
 */
public class TopTranferDTO {

	/**
	 * @param name
	 * @param email
	 * @param importe
	 * @param nombreServicio
	 * @param nombreEmpresa
	 */
	public TopTranferDTO(String name, String email, Double importe, String nombreServicio, String nombreEmpresa) {
		super();
		this.name = name;
		this.email = email;
		this.importe = importe;
		this.nombreServicio = nombreServicio;
		this.nombreEmpresa = nombreEmpresa;
	}

	public TopTranferDTO() {

	}

	private String name;

	private String email;

	private Double importe;

	private String nombreServicio;

	private String nombreEmpresa;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getNombreServicio() {
		return nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

}
