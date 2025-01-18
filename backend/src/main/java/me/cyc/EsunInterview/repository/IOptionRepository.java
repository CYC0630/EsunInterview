package me.cyc.EsunInterview.repository;

import me.cyc.EsunInterview.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOptionRepository extends JpaRepository<Option, Long>
{
}