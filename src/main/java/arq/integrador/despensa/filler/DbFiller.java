package arq.integrador.despensa.filler;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import arq.integrador.despensa.entities.Cliente;
import arq.integrador.despensa.entities.Producto;
import arq.integrador.despensa.repositories.ClienteRepository;
import arq.integrador.despensa.repositories.ProductoRepository;

@Configuration
public class DbFiller {
	
	@Bean
	public CommandLineRunner initDb(ClienteRepository cliente, ProductoRepository producto) {
		return args-> {
			IntStream.range(0, 10).forEach(i->{
							
				Cliente c = new Cliente("Cliente "+i,"Direccion"+i);
				cliente.save(c);
			});
			IntStream.range(0, 10).forEach(i->{
				
				Producto p = new Producto("Producto"+i,(int) Math.floor(Math.random()*50),Math.round((double) Math.random()*1000));
				producto.save(p);
			});
			
		};
	}

}
