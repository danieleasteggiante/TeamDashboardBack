package it.gend.teamdashboardback;

import it.gend.teamdashboardback.entity.JobDescription;
import it.gend.teamdashboardback.entity.Member;
import it.gend.teamdashboardback.entity.Product;
import it.gend.teamdashboardback.entity.ProductVersion;
import it.gend.teamdashboardback.entity.ReleaseLocation;
import it.gend.teamdashboardback.entity.TableRow;
import it.gend.teamdashboardback.entity.Team;
import it.gend.teamdashboardback.repository.JobDescriptionRepository;
import it.gend.teamdashboardback.repository.MemberRepository;
import it.gend.teamdashboardback.repository.ProductRepository;
import it.gend.teamdashboardback.repository.ProductVersionRepository;
import it.gend.teamdashboardback.repository.TableRowRepository;
import it.gend.teamdashboardback.repository.TeamRepository;
import it.gend.teamdashboardback.utils.IdGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author Daniele Asteggiante
 */
//@Component
public class MockData implements CommandLineRunner {
    ProductRepository productRepository;
    TeamRepository teamRepository;
    JobDescriptionRepository jobDescriptionRepository;
    ProductVersionRepository productVersionRepository;
    TableRowRepository tableRowRepository;
    MemberRepository memberRepository;
    IdGenerator idGenerator;

    public MockData(ProductRepository productRepository, TeamRepository teamRepository, JobDescriptionRepository jobDescriptionRepository, ProductVersionRepository productVersionRepository, TableRowRepository tableRowRepository, MemberRepository memberRepository, IdGenerator idGenerator) {
        this.productRepository = productRepository;
        this.teamRepository = teamRepository;
        this.jobDescriptionRepository = jobDescriptionRepository;
        this.productVersionRepository = productVersionRepository;
        this.tableRowRepository = tableRowRepository;
        this.memberRepository = memberRepository;
        this.idGenerator = idGenerator;
    }

    @Override
    public void run(String... args) throws Exception {

        // Create team cancelleria
        Team team = new Team();
        team.setId(idGenerator.getId(Team.class));
        team.setName("Cancelleria");
        team.setDescription("Cancelleria team");
        teamRepository.save(team);

        // Create team desk
        Team team2 = new Team();
        team2.setId(idGenerator.getId(Team.class));
        team2.setName("Desk");
        team2.setDescription("Desk team");
        teamRepository.save(team2);

        // Create member
        Member member = new Member();
        member.setId(idGenerator.getId(Member.class));
        member.setName("Mario");
        member.setSurname("Rossi");
        member.setRole("Developer");
        member.setTeam(team);
        member.setEmail("mariorossi@test.it");

        JobDescription jobDescription = new JobDescription();
        jobDescription.setId(idGenerator.getId(JobDescription.class));
        jobDescription.setDescription("Developer");
        jobDescriptionRepository.save(jobDescription);

        // Set job description
        member.setJobDescription(jobDescription);
        memberRepository.save(member);

        // Create member
        Member member2 = new Member();
        member2.setId(idGenerator.getId(Member.class));
        member2.setName("Giorgio");
        member2.setSurname("Bianchi");
        member2.setRole("Developer");
        member2.setTeam(team2);
        member2.setEmail("gbianchi@test.it");

        // Set job description
        member2.setJobDescription(jobDescription);
        memberRepository.save(member2);

        // Create product CSC
        Product product = new Product();
        product.setId(idGenerator.getId(Product.class));
        product.setName("CSC-Client");
        product.setDescription("Client for CSC");
        product.setTeam(team);
        productRepository.save(product);

        // Create DESK
        Product product2 = new Product();
        product2.setId(idGenerator.getId(Product.class));
        product2.setName("Desk");
        product2.setDescription("Desk for Magistrato");
        product2.setTeam(team);
        productRepository.save(product2);

        // Create product version
        ProductVersion productVersion = new ProductVersion();
        productVersion.setId(idGenerator.getId(ProductVersion.class));
        productVersion.setProduct(product);
        productVersion.setVersion("1.0.0");
        productVersion.setDescription("First version");
        productVersion.setActive(true);
        productVersionRepository.save(productVersion);

        // Create product version
        ProductVersion productVersion2 = new ProductVersion();
        productVersion2.setId(idGenerator.getId(ProductVersion.class));
        productVersion2.setProduct(product2);
        productVersion2.setVersion("1.0.3");
        productVersion2.setDescription("Tiket 1 fixed");
        productVersion2.setActive(true);
        productVersionRepository.save(productVersion2);

        // Create table row
        TableRow tableRow = new TableRow();
        tableRow.setId(idGenerator.getId(TableRow.class));
        tableRow.setDate(java.time.LocalDate.now());
        tableRow.setBranch("master");
        tableRow.setProductVersions(Set.of(productVersion, productVersion2));
        tableRow.setReleaseLocation(ReleaseLocation.COLLAUDO);
        tableRowRepository.save(tableRow);

    }
}
