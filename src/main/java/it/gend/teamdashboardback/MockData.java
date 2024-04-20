package it.gend.teamdashboardback;

import it.gend.teamdashboardback.entity.JobDescription;
import it.gend.teamdashboardback.entity.Member;
import it.gend.teamdashboardback.entity.Product;
import it.gend.teamdashboardback.entity.ProductVersion;
import it.gend.teamdashboardback.entity.TableRow;
import it.gend.teamdashboardback.entity.Team;
import it.gend.teamdashboardback.repository.JobDescriptionRepository;
import it.gend.teamdashboardback.repository.MemberRepository;
import it.gend.teamdashboardback.repository.ProductRepository;
import it.gend.teamdashboardback.repository.ProductVersionRepository;
import it.gend.teamdashboardback.repository.TableRowRepository;
import it.gend.teamdashboardback.repository.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author Daniele Asteggiante
 */
@Component
public class MockData implements CommandLineRunner {
    ProductRepository productRepository;
    TeamRepository teamRepository;
    JobDescriptionRepository jobDescriptionRepository;
    ProductVersionRepository productVersionRepository;
    TableRowRepository tableRowRepository;
    MemberRepository memberRepository;

    public MockData(ProductRepository productRepository, TeamRepository teamRepository, JobDescriptionRepository jobDescriptionRepository, ProductVersionRepository productVersionRepository, TableRowRepository tableRowRepository, MemberRepository memberRepository) {
        this.productRepository = productRepository;
        this.teamRepository = teamRepository;
        this.jobDescriptionRepository = jobDescriptionRepository;
        this.productVersionRepository = productVersionRepository;
        this.tableRowRepository = tableRowRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Create team
        Team team = new Team();
        team.setId(1);
        team.setName("Cancelleria");
        team.setDescription("Cancelleria team");
        teamRepository.save(team);

        // Create member
        Member member = new Member();
        member.setId(1);
        member.setName("Mario");
        member.setSurname("Rossi");
        member.setRole("Developer");
        member.setTeam(team);
        member.setEmail("mariorossi@test.it");

        // Create job description
        JobDescription jobDescription = new JobDescription();
        jobDescription.setId(1);
        jobDescription.setDescription("Developer");
        jobDescriptionRepository.save(jobDescription);

        // Set job description
        member.setJobDescription(jobDescription);
        memberRepository.save(member);

        // Create product
        Product product = new Product();
        product.setId(1);
        product.setName("CSC-Client");
        product.setDescription("Client for CSC");
        product.setTeam(team);
        productRepository.save(product);

        // Create product version
        ProductVersion productVersion = new ProductVersion();
        productVersion.setId(1);
        productVersion.setProduct(product);
        productVersion.setVersion("1.0.0");
        productVersion.setDescription("First version");
        productVersion.setActive(true);
        productVersionRepository.save(productVersion);

        // Create table row
        TableRow tableRow = new TableRow();
        tableRow.setId(1);
        tableRow.setDate(java.time.LocalDate.now());
        tableRow.setBranch("master");
        tableRow.setProductVersions(Set.of(productVersion));
        tableRowRepository.save(tableRow);

    }
}
