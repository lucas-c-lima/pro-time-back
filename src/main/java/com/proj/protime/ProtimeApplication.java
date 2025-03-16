package com.proj.protime;

import com.proj.protime.entity.Activities;
import com.proj.protime.entity.HoursEntry;
import com.proj.protime.entity.Projects;
import com.proj.protime.entity.Users;
import com.proj.protime.entity.enums.ActivityStatus;
import com.proj.protime.entity.enums.ProfileUser;
import com.proj.protime.entity.enums.ProjectPriority;
import com.proj.protime.entity.enums.ProjectStatus;
import com.proj.protime.repository.ActivitiesRepository;
import com.proj.protime.repository.HoursEntryRepository;
import com.proj.protime.repository.ProjectsRepository;
import com.proj.protime.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ProtimeApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private ProjectsRepository projectsRepository;
	@Autowired
	private ActivitiesRepository activitiesRepository;
	@Autowired
	private HoursEntryRepository hoursEntryRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProtimeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String checkTableEmptyQuery = "SELECT COUNT(*) FROM usuarios";
		Integer count = jdbcTemplate.queryForObject(checkTableEmptyQuery, Integer.class);
		if (count == 0) {
			System.out.println("Generating default users data...");
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

			Users user1 = new Users("Administração Conta", "admin@admin.com", passwordEncoder.encode("adm123"), ProfileUser.ADMIN);
			Users user2 = new Users("Maria Oliveira", "maria.oliveira@hotmail.com", passwordEncoder.encode("senha456"), ProfileUser.USUARIO);
			Users user3 = new Users("João Santos", "joao.santos@yahoo.com.br", passwordEncoder.encode("senha789"), ProfileUser.USUARIO);
			Users user4 = new Users("Ana Costa", "ana.costa@outlook.com", passwordEncoder.encode("senha101"), ProfileUser.USUARIO);
			Users user5 = new Users("Paulo Souza", "paulo.souza@gmail.com", passwordEncoder.encode("senha112"), ProfileUser.USUARIO);
			Users user6 = new Users("Fernanda Pereira", "fernanda.pereira@gmail.com", passwordEncoder.encode("senha131"), ProfileUser.USUARIO);
			Users user7 = new Users("Lucas Almeida", "lucas.almeida@hotmail.com", passwordEncoder.encode("senha415"), ProfileUser.USUARIO);
			Users user8 = new Users("Juliana Lima", "juliana.lima@yahoo.com.br", passwordEncoder.encode("senha161"), ProfileUser.USUARIO);
			Users user9 = new Users("Rafael Rocha", "rafael.rocha@outlook.com", passwordEncoder.encode("senha718"), ProfileUser.USUARIO);
			Users user10 = new Users("Beatriz Martins", "beatriz.martins@gmail.com", passwordEncoder.encode("senha192"), ProfileUser.USUARIO);

			List<Users> usersList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
			usersRepository.saveAll(usersList);
		}
		checkTableEmptyQuery = "SELECT COUNT(*) FROM projeto";
		count = jdbcTemplate.queryForObject(checkTableEmptyQuery, Integer.class);
		if (count == 0) {
			System.out.println("Generating default projects data...");
			Projects project1 = new Projects("Desenvolvimento de Aplicação", "Projeto para o desenvolvimento de uma aplicação web para gerenciamento de tarefas.", LocalDateTime.of(2025, 2, 1, 9, 0), LocalDateTime.of(2025, 3, 14, 18, 0), ProjectStatus.EM_ANDAMENTO, usersRepository.findById(1).get(), ProjectPriority.ALTA);
			Projects project2 = new Projects("Automatização de Processos", "Projeto para automação de processos internos da empresa utilizando ferramentas de RPA.", LocalDateTime.of(2025, 1, 10, 8, 30), LocalDateTime.of(2025, 3, 1, 17, 0), ProjectStatus.PLANEJADO, usersRepository.findById(2).get(), ProjectPriority.MEDIA);
			Projects project3 = new Projects("Reestruturação de Infraestrutura", "Projeto para reestruturação da infraestrutura de TI da empresa.", LocalDateTime.of(2025, 2, 5, 10, 0), LocalDateTime.of(2025, 4, 10, 16, 0), ProjectStatus.EM_ANDAMENTO, usersRepository.findById(3).get(), ProjectPriority.ALTA);
			Projects project4 = new Projects("Desenvolvimento de API", "Projeto para o desenvolvimento de uma API RESTful para integração com sistemas de terceiros.", LocalDateTime.of(2025, 3, 1, 9, 0), LocalDateTime.of(2025, 5, 15, 18, 0), ProjectStatus.PLANEJADO, usersRepository.findById(4).get(), ProjectPriority.BAIXA);
			Projects project5 = new Projects("Pesquisa de Mercado", "Projeto para realizar uma pesquisa de mercado sobre novas tendências tecnológicas.", LocalDateTime.of(2025, 1, 20, 14, 0), LocalDateTime.of(2025, 2, 28, 16, 0), ProjectStatus.CONCLUIDO, usersRepository.findById(5).get(), ProjectPriority.MEDIA);
			Projects project6 = new Projects("Aprimoramento de Segurança", "Projeto para melhorar a segurança da rede interna da empresa.", LocalDateTime.of(2025, 2, 15, 8, 0), LocalDateTime.of(2025, 3, 31, 17, 0), ProjectStatus.EM_ANDAMENTO, usersRepository.findById(6).get(), ProjectPriority.ALTA);
			Projects project7 = new Projects("Integração com CRM", "Projeto para integrar o sistema de vendas ao novo CRM da empresa.", LocalDateTime.of(2025, 3, 1, 9, 0), LocalDateTime.of(2025, 4, 10, 18, 0), ProjectStatus.PLANEJADO, usersRepository.findById(7).get(), ProjectPriority.MEDIA);
			Projects project8 = new Projects("Desenvolvimento de Chatbot", "Projeto para o desenvolvimento de um chatbot para atendimento automatizado.", LocalDateTime.of(2025, 2, 20, 10, 0), LocalDateTime.of(2025, 4, 5, 18, 0), ProjectStatus.EM_ANDAMENTO, usersRepository.findById(8).get(), ProjectPriority.BAIXA);
			Projects project9 = new Projects("Migração de Dados", "Projeto para migração dos dados de clientes para uma nova plataforma.", LocalDateTime.of(2025, 1, 15, 8, 0), LocalDateTime.of(2025, 3, 20, 17, 0), ProjectStatus.CONCLUIDO, usersRepository.findById(9).get(), ProjectPriority.ALTA);
			Projects project10 = new Projects("Treinamento de Equipe", "Projeto para treinamento da equipe de vendas sobre as novas ferramentas da empresa.", LocalDateTime.of(2025, 3, 10, 9, 0), LocalDateTime.of(2025, 3, 25, 16, 0), ProjectStatus.PLANEJADO, usersRepository.findById(10).get(), ProjectPriority.MEDIA);

			List<Projects> projectsList = Arrays.asList(project1, project2, project3, project4, project5, project6, project7, project8, project9, project10);
			projectsRepository.saveAll(projectsList);
		}
		checkTableEmptyQuery = "SELECT COUNT(*) FROM atividades";
		count = jdbcTemplate.queryForObject(checkTableEmptyQuery, Integer.class);
		if (count == 0) {
			System.out.println("Generating default activities data...");

			Activities activity1 = new Activities("Levantamento de Requisitos", "Análise de requisitos do sistema de gerenciamento de tarefas.", LocalDateTime.of(2025, 1, 10, 10, 0), LocalDateTime.of(2025, 1, 15, 18, 0), ActivityStatus.CONCLUIDA, projectsRepository.findById(1).get(), usersRepository.findById(3).get());
			Activities activity2 = new Activities("Desenvolvimento do Front-End", "Desenvolvimento da interface gráfica da aplicação para gerenciamento de tarefas.", LocalDateTime.of(2025, 1, 16, 9, 0), LocalDateTime.of(2025, 2, 10, 18, 0), ActivityStatus.EM_ANDAMENTO, projectsRepository.findById(1).get(), usersRepository.findById(4).get());
			Activities activity3 = new Activities("Testes de Funcionalidade", "Execução de testes para validar o funcionamento das funcionalidades da aplicação.", LocalDateTime.of(2025, 2, 15, 8, 0), LocalDateTime.of(2025, 2, 25, 17, 0), ActivityStatus.PAUSADA, projectsRepository.findById(1).get(), usersRepository.findById(5).get());
			Activities activity4 = new Activities("Mapeamento de Processos", "Identificação e mapeamento dos processos a serem automatizados.", LocalDateTime.of(2025, 1, 10, 10, 0), LocalDateTime.of(2025, 1, 20, 18, 0), ActivityStatus.CONCLUIDA, projectsRepository.findById(2).get(), usersRepository.findById(6).get());
			Activities activity5 = new Activities("Desenvolvimento do RPA", "Criação de scripts de automação utilizando ferramentas de RPA.", LocalDateTime.of(2025, 1, 25, 9, 0), LocalDateTime.of(2025, 2, 15, 18, 0), ActivityStatus.EM_ANDAMENTO, projectsRepository.findById(2).get(), usersRepository.findById(7).get());
			Activities activity6 = new Activities("Auditoria de Infraestrutura", "Análise e auditoria da infraestrutura atual para identificar pontos de melhoria.", LocalDateTime.of(2025, 1, 15, 10, 0), LocalDateTime.of(2025, 1, 25, 18, 0), ActivityStatus.CONCLUIDA, projectsRepository.findById(3).get(), usersRepository.findById(8).get());
			Activities activity7 = new Activities("Implantação de Novos Servidores", "Instalação e configuração dos novos servidores para a empresa.", LocalDateTime.of(2025, 2, 1, 8, 0), LocalDateTime.of(2025, 2, 20, 18, 0), ActivityStatus.PAUSADA, projectsRepository.findById(3).get(), usersRepository.findById(9).get());
			Activities activity8 = new Activities("Especificação de Endpoints", "Definição dos endpoints necessários para a API de integração.", LocalDateTime.of(2025, 1, 12, 10, 0), LocalDateTime.of(2025, 1, 20, 18, 0), ActivityStatus.CONCLUIDA, projectsRepository.findById(4).get(), usersRepository.findById(10).get());
			Activities activity9 = new Activities("Desenvolvimento da API", "Implementação dos endpoints definidos para a API.", LocalDateTime.of(2025, 1, 25, 9, 0), LocalDateTime.of(2025, 2, 15, 18, 0), ActivityStatus.EM_ANDAMENTO, projectsRepository.findById(4).get(), usersRepository.findById(1).get());
			Activities activity10 = new Activities("Definição do Escopo da Pesquisa", "Determinação das questões a serem abordadas na pesquisa de mercado.", LocalDateTime.of(2025, 1, 10, 9, 0), LocalDateTime.of(2025, 1, 15, 17, 0), ActivityStatus.CONCLUIDA, projectsRepository.findById(5).get(), usersRepository.findById(2).get());
			Activities activity11 = new Activities("Coleta de Dados", "Realização de entrevistas e questionários para coleta de dados sobre as tendências.", LocalDateTime.of(2025, 1, 20, 10, 0), LocalDateTime.of(2025, 2, 5, 18, 0), ActivityStatus.PAUSADA, projectsRepository.findById(5).get(), usersRepository.findById(3).get());
			Activities activity12 = new Activities("Análise de Riscos de Segurança", "Realização de uma análise detalhada dos riscos de segurança na rede interna.", LocalDateTime.of(2025, 2, 1, 10, 0), LocalDateTime.of(2025, 2, 10, 18, 0), ActivityStatus.CONCLUIDA, projectsRepository.findById(6).get(), usersRepository.findById(4).get());
			Activities activity13 = new Activities("Implantação de Firewalls", "Configuração e instalação de firewalls para proteger a rede corporativa.", LocalDateTime.of(2025, 2, 15, 8, 0), LocalDateTime.of(2025, 3, 1, 18, 0), ActivityStatus.EM_ANDAMENTO, projectsRepository.findById(6).get(), usersRepository.findById(5).get());
			Activities activity14 = new Activities("Planejamento da Integração", "Definição do plano de integração entre o sistema de vendas e o CRM.", LocalDateTime.of(2025, 2, 5, 9, 0), LocalDateTime.of(2025, 2, 15, 18, 0), ActivityStatus.CONCLUIDA, projectsRepository.findById(7).get(), usersRepository.findById(6).get());
			Activities activity15 = new Activities("Desenvolvimento da Integração", "Criação da integração entre o sistema de vendas e o CRM.", LocalDateTime.of(2025, 2, 20, 10, 0), LocalDateTime.of(2025, 3, 5, 18, 0), ActivityStatus.PAUSADA, projectsRepository.findById(7).get(), usersRepository.findById(7).get());
			Activities activity16 = new Activities("Pesquisa de Mercado", "Pesquisa para entender as necessidades do público-alvo para o chatbot.", LocalDateTime.of(2025, 2, 1, 9, 0), LocalDateTime.of(2025, 2, 10, 18, 0), ActivityStatus.CONCLUIDA, projectsRepository.findById(8).get(), usersRepository.findById(8).get());
			Activities activity17 = new Activities("Desenvolvimento do Chatbot", "Desenvolvimento do algoritmo e lógica do chatbot.", LocalDateTime.of(2025, 2, 15, 8, 0), LocalDateTime.of(2025, 3, 1, 18, 0), ActivityStatus.EM_ANDAMENTO, projectsRepository.findById(8).get(), usersRepository.findById(9).get());
			Activities activity18 = new Activities("Mapeamento de Dados", "Identificação dos dados necessários para migração para a nova plataforma.", LocalDateTime.of(2025, 1, 5, 8, 0), LocalDateTime.of(2025, 1, 15, 18, 0), ActivityStatus.CONCLUIDA, projectsRepository.findById(9).get(), usersRepository.findById(10).get());
			Activities activity19 = new Activities("Execução da Migração", "Execução da migração dos dados de clientes para a nova plataforma.", LocalDateTime.of(2025, 1, 20, 9, 0), LocalDateTime.of(2025, 2, 5, 18, 0), ActivityStatus.PAUSADA, projectsRepository.findById(9).get(), usersRepository.findById(1).get());
			Activities activity20 = new Activities("Planejamento do Treinamento", "Elaboração do conteúdo e cronograma para o treinamento da equipe de vendas.", LocalDateTime.of(2025, 2, 1, 10, 0), LocalDateTime.of(2025, 2, 5, 17, 0), ActivityStatus.CONCLUIDA, projectsRepository.findById(10).get(), usersRepository.findById(2).get());
			Activities activity21 = new Activities("Execução do Treinamento", "Realização do treinamento prático com a equipe de vendas.", LocalDateTime.of(2025, 2, 10, 9, 0), LocalDateTime.of(2025, 2, 20, 18, 0), ActivityStatus.PAUSADA, projectsRepository.findById(10).get(), usersRepository.findById(3).get());

			List<Activities> activitiesList = Arrays.asList(
					activity1, activity2, activity3, activity4, activity5, activity6, activity7, activity8, activity9, activity10,
					activity11, activity12, activity13, activity14, activity15, activity16, activity17, activity18, activity19, activity20, activity21
			);
			activitiesRepository.saveAll(activitiesList);
		}
		checkTableEmptyQuery = "SELECT COUNT(*) FROM lancamentos_horas";
		count = jdbcTemplate.queryForObject(checkTableEmptyQuery, Integer.class);
		if(count == 0) {
			System.out.println("Generating default time entries data...");
			HoursEntry hoursEntry1 = new HoursEntry(activitiesRepository.findById(1).get(), usersRepository.findById(3).get(), "Reunião de Levantamento de requisitos", LocalDateTime.of(2025, 1, 10, 10, 0), LocalDateTime.of(2025, 1, 10, 12, 0));
			HoursEntry hoursEntry2 = new HoursEntry(activitiesRepository.findById(2).get(), usersRepository.findById(4).get(), "Desenvolvimento da interface gráfica", LocalDateTime.of(2025, 1, 16, 9, 0), LocalDateTime.of(2025, 1, 16, 12, 0));
			HoursEntry hoursEntry3 = new HoursEntry(activitiesRepository.findById(3).get(), usersRepository.findById(5).get(), "Execução de testes de funcionalidade", LocalDateTime.of(2025, 2, 15, 8, 0), LocalDateTime.of(2025, 2, 15, 12, 0));
			HoursEntry hoursEntry4 = new HoursEntry(activitiesRepository.findById(4).get(), usersRepository.findById(6).get(), "Reunião de Mapeamento de Processos", LocalDateTime.of(2025, 1, 10, 10, 0), LocalDateTime.of(2025, 1, 10, 12, 0));
			HoursEntry hoursEntry5 = new HoursEntry(activitiesRepository.findById(5).get(), usersRepository.findById(7).get(), "Desenvolvimento do script de automação", LocalDateTime.of(2025, 1, 25, 9, 0), LocalDateTime.of(2025, 1, 25, 12, 0));
			HoursEntry hoursEntry6 = new HoursEntry(activitiesRepository.findById(6).get(), usersRepository.findById(8).get(), "Auditoria de Infraestrutura", LocalDateTime.of(2025, 1, 15, 10, 0), LocalDateTime.of(2025, 1, 15, 12, 0));
			HoursEntry hoursEntry7 = new HoursEntry(activitiesRepository.findById(7).get(), usersRepository.findById(9).get(), "Instalação de servidores", LocalDateTime.of(2025, 2, 1, 8, 0), LocalDateTime.of(2025, 2, 1, 12, 0));
			HoursEntry hoursEntry8 = new HoursEntry(activitiesRepository.findById(8).get(), usersRepository.findById(10).get(), "Especificação de endpoints da API", LocalDateTime.of(2025, 1, 12, 10, 0), LocalDateTime.of(2025, 1, 12, 12, 0));
			HoursEntry hoursEntry9 = new HoursEntry(activitiesRepository.findById(9).get(), usersRepository.findById(1).get(), "Desenvolvimento dos endpoints da API", LocalDateTime.of(2025, 1, 25, 9, 0), LocalDateTime.of(2025, 1, 25, 12, 0));
			HoursEntry hoursEntry10 = new HoursEntry(activitiesRepository.findById(10).get(), usersRepository.findById(2).get(), "Planejamento da pesquisa de mercado", LocalDateTime.of(2025, 1, 10, 9, 0), LocalDateTime.of(2025, 1, 10, 12, 0));
			HoursEntry hoursEntry11 = new HoursEntry(activitiesRepository.findById(11).get(), usersRepository.findById(3).get(), "Coleta de dados para a pesquisa", LocalDateTime.of(2025, 1, 20, 10, 0), LocalDateTime.of(2025, 1, 20, 12, 0));
			HoursEntry hoursEntry12 = new HoursEntry(activitiesRepository.findById(12).get(), usersRepository.findById(4).get(), "Análise de riscos de segurança", LocalDateTime.of(2025, 2, 1, 10, 0), LocalDateTime.of(2025, 2, 1, 12, 0));
			HoursEntry hoursEntry13 = new HoursEntry(activitiesRepository.findById(13).get(), usersRepository.findById(5).get(), "Configuração de firewalls", LocalDateTime.of(2025, 2, 15, 8, 0), LocalDateTime.of(2025, 2, 15, 12, 0));
			HoursEntry hoursEntry14 = new HoursEntry(activitiesRepository.findById(14).get(), usersRepository.findById(6).get(), "Planejamento da integração", LocalDateTime.of(2025, 2, 5, 9, 0), LocalDateTime.of(2025, 2, 5, 12, 0));
			HoursEntry hoursEntry15 = new HoursEntry(activitiesRepository.findById(15).get(), usersRepository.findById(7).get(), "Desenvolvimento da integração", LocalDateTime.of(2025, 2, 20, 10, 0), LocalDateTime.of(2025, 2, 20, 12, 0));
			HoursEntry hoursEntry16 = new HoursEntry(activitiesRepository.findById(16).get(), usersRepository.findById(8).get(), "Pesquisa de mercado para o chatbot", LocalDateTime.of(2025, 2, 1, 9, 0), LocalDateTime.of(2025, 2, 1, 12, 0));
			HoursEntry hoursEntry17 = new HoursEntry(activitiesRepository.findById(17).get(), usersRepository.findById(9).get(), "Desenvolvimento do chatbot", LocalDateTime.of(2025, 2, 15, 8, 0), LocalDateTime.of(2025, 2, 15, 12, 0));
			HoursEntry hoursEntry18 = new HoursEntry(activitiesRepository.findById(18).get(), usersRepository.findById(10).get(), "Mapeamento de dados", LocalDateTime.of(2025, 1, 5, 8, 0), LocalDateTime.of(2025, 1, 5, 12, 0));
			HoursEntry hoursEntry19 = new HoursEntry(activitiesRepository.findById(19).get(), usersRepository.findById(1).get(), "Execução da migração dos dados", LocalDateTime.of(2025, 1, 20, 9, 0), LocalDateTime.of(2025, 1, 20, 12, 0));
			HoursEntry hoursEntry20 = new HoursEntry(activitiesRepository.findById(20).get(), usersRepository.findById(2).get(), "Planejamento do treinamento", LocalDateTime.of(2025, 2, 1, 10, 0), LocalDateTime.of(2025, 2, 1, 12, 0));
			HoursEntry hoursEntry21 = new HoursEntry(activitiesRepository.findById(21).get(), usersRepository.findById(3).get(), "Execução do treinamento", LocalDateTime.of(2025, 2, 10, 9, 0), LocalDateTime.of(2025, 2, 10, 12, 0));

			List<HoursEntry> hoursEntryList = Arrays.asList(hoursEntry1, hoursEntry2, hoursEntry3, hoursEntry4, hoursEntry5, hoursEntry6, hoursEntry7, hoursEntry8, hoursEntry9, hoursEntry10, hoursEntry11, hoursEntry12, hoursEntry13, hoursEntry14, hoursEntry15, hoursEntry16, hoursEntry17, hoursEntry18, hoursEntry19, hoursEntry20, hoursEntry21);
			hoursEntryRepository.saveAll(hoursEntryList);
		}
	}
}
