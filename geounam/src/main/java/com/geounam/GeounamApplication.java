package com.geounam;

//import java.io.BufferedReader;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
import java.util.HashSet;
//import java.util.List;
import java.util.Set;
//import java.util.stream.Collectors;
//
//import org.locationtech.jts.geom.Coordinate;
//import org.locationtech.jts.geom.GeometryFactory;
//import org.locationtech.jts.geom.Point;
//import org.locationtech.jts.geom.PrecisionModel;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//import com.bedatadriven.jackson.datatype.jts.JtsModule;
//import com.geounam.entity.EntidadFederativa;
//import com.geounam.entity.Incidente;
import com.geounam.entity.Municipio;
//import com.geounam.service.EntidadFederativaService;
//import com.geounam.service.IncidenteService;
//import com.geounam.service.MunicipioService;

@SpringBootApplication
@EnableAutoConfiguration
public class GeounamApplication {
/*
	private static final int LOCALIDAD_PRINCIPAL = 1;

	@Autowired
	private EntidadFederativaService entidadFederativaService;

	@Autowired
	private MunicipioService municipioService;

	@Autowired
	private IncidenteService incidenteService;
*/
	Set<Municipio> municipios = new HashSet<>();

	public static void main(String[] args) {
		SpringApplication.run(GeounamApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
/*
		Path pathLocalidades = Paths.get("/home/edgar/Documentos/watson/localidades.csv");
		Path pathIncidentes = Paths.get("/home/edgar/Documentos/watson/200511COVID19MEXICO.csv");

		try (BufferedReader reader = Files.newBufferedReader(pathLocalidades)) {

			String line = reader.readLine();
			GeometryFactory geomFactory = new GeometryFactory(new PrecisionModel(), 4326);

			int entidadId = 1;
			int municipioId = 1;

			while (line != null) {
				if (!line.startsWith("#")) {
					String[] localidad = line.split("\",\"");
					int claveEntidad = Integer.parseInt(localidad[0].replace("\"", ""));
					String nombreEntidad = localidad[1];
					int claveMunicipio = Integer.parseInt(localidad[3].replace("\"", ""));
					String nombreMunicipio = localidad[4];
					float latitud = Float.parseFloat(localidad[8]);
					float longitud = Float.parseFloat(localidad[9]);
					int claveLocalidad = Integer.parseInt(localidad[5]);
					if (claveLocalidad == LOCALIDAD_PRINCIPAL) {
						boolean esNuevaEntidadFederativa = claveEntidad == entidadId;
						if (esNuevaEntidadFederativa) {
							EntidadFederativa e = new EntidadFederativa(claveEntidad, nombreEntidad);
							entidadFederativaService.save(e);
							entidadId++;
						}
						Point punto = geomFactory.createPoint(new Coordinate(latitud, longitud));
						Municipio m = new Municipio(municipioId, nombreMunicipio, claveMunicipio, claveEntidad, punto);
						municipios.add(m);
						municipioId++;
					}
				}
				line = reader.readLine();
			}
			System.out.println("Guardando municipios en base de datos...");
			municipioService.saveAll(municipios);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (BufferedReader reader = Files.newBufferedReader(pathIncidentes,Charset.forName("ISO-8859-1"))) {

			Set<Incidente> incidentes = new HashSet<Incidente>();

			String line = reader.readLine();
			int incidenteId = 1;
			while (line != null) {
				if (!line.startsWith("#")) {

					Incidente incidente = toIncidente(line, incidenteId);
					System.out.println("Añadiendo incidente: " + incidente);
					if(incidente != null) {
						incidentes.add(incidente);
					}

					incidenteId++;
				}
				line = reader.readLine();
				//System.out.println("\rIncidente: " + incidenteId);
			}
			System.out.println("Guardando incidentes en base de datos...");
			incidenteService.saveAll(incidentes);
			System.out.println("OK");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return null;
	}

//	private Incidente toIncidente(String line, int incidenteId) {
//		String[] lineaIncidente = line.split(",");
//		int claveMunicipio = Integer.parseInt(lineaIncidente[8].replace("\"", ""));
//		int claveEntidad = Integer.parseInt(lineaIncidente[7].replace("\"", ""));
//		// Municipio municipioResidencia =
//		// municipioService.findByClaveMunicipioAndClaveEntidad(claveMunicipio,
//		// claveEntidad);
//		System.out.println("Obteniendo municipio: cve_entidad = " + claveEntidad + " cve_muni = " + claveMunicipio);
//		List<Municipio> municipio = municipios.stream()
//				.filter(m -> m.getClaveMunicipio() == claveMunicipio && m.getClaveEntidad() == claveEntidad)
//				.collect(Collectors.toList());
//		Municipio municipioResidencia;
//		if(municipio.size() == 1) {
//			municipioResidencia = municipio.get(0);
//		}else {
//			//Sin ubicación, el dato se desecha
//			return null;
//		}
//		int tipoPaciente = Integer.parseInt(lineaIncidente[9]);
//		Calendar fechaIngreso = toCalendar(lineaIncidente[10].replace("\"", ""));
//		Calendar fechaSintomas = toCalendar(lineaIncidente[11].replace("\"", ""));
//		Calendar fechaDefuncion = toCalendar(lineaIncidente[12].replace("\"", ""));
//		if(!fechaDefuncion.getTime().toString().contains("2020")) {
//			fechaDefuncion=null;
//		}
//		int intubado = Integer.parseInt(lineaIncidente[13]);
//		int neumonia = Integer.parseInt(lineaIncidente[14]);
//		int edad = Integer.parseInt(lineaIncidente[15]);
//		int embarazo = Integer.parseInt(lineaIncidente[17]);
//		int diabetes = Integer.parseInt(lineaIncidente[19]);
//		int epoc = Integer.parseInt(lineaIncidente[20]);
//		int asma = Integer.parseInt(lineaIncidente[21]);
//		int inmunosupresion = Integer.parseInt(lineaIncidente[22]);
//		int hipertension = Integer.parseInt(lineaIncidente[23]);
//		int cardiovascular = Integer.parseInt(lineaIncidente[25]);
//		int obesidad = Integer.parseInt(lineaIncidente[26]);
//		int renalCronica = Integer.parseInt(lineaIncidente[27]);
//		int tabaquismo = Integer.parseInt(lineaIncidente[28]);
//		int resultado = Integer.parseInt(lineaIncidente[30]);
//
//		Incidente incidente = new Incidente(incidenteId, municipioResidencia, tipoPaciente, fechaIngreso, fechaSintomas,
//				fechaDefuncion, edad, intubado, neumonia, embarazo, diabetes, asma, inmunosupresion, hipertension,
//				cardiovascular, obesidad, epoc, renalCronica, tabaquismo, resultado);
//		return incidente;
//	}
//
//	public Calendar toCalendar(String strDate) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date date;
//		try {
//			date = sdf.parse(strDate);
//			Calendar cal = Calendar.getInstance();
//			cal.setTime(date);
//			return cal;
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
}