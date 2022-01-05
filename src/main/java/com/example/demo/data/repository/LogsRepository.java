package com.example.demo.data.repository;

import com.example.demo.data.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepository extends JpaRepository<Log, Long> {}