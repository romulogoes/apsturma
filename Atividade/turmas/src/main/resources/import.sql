-- Inserção de cursos
INSERT INTO curso (nome) VALUES ('Matemática');
INSERT INTO curso (nome) VALUES ('História');

-- Inserção de professores
INSERT INTO professor (nome, especialidade) VALUES ('Carlos Silva', 'Álgebra Linear');
INSERT INTO professor (nome, especialidade) VALUES ('Maria Lima', 'História do Brasil');

-- Inserção de turmas
INSERT INTO turma (horario, curso_id, professor_id) VALUES ('08:00 - 10:00', 1, 1);
INSERT INTO turma (horario, curso_id, professor_id) VALUES ('10:00 - 12:00', 2, 2);

-- Inserção de estudantes
INSERT INTO estudante (nome, matricula) VALUES ('João', 1001);
INSERT INTO estudante (nome, matricula) VALUES ('Ana', 1002);
INSERT INTO estudante (nome, matricula) VALUES ('Pedro', 1003);
INSERT INTO estudante (nome, matricula) VALUES ('Maria', 1004);
INSERT INTO estudante (nome, matricula) VALUES ('Carlos', 1005);
INSERT INTO estudante (nome, matricula) VALUES ('Julia', 1006);
INSERT INTO estudante (nome, matricula) VALUES ('Lucas', 1007);
INSERT INTO estudante (nome, matricula) VALUES ('Fernanda', 1008);
INSERT INTO estudante (nome, matricula) VALUES ('Rafael', 1009);
INSERT INTO estudante (nome, matricula) VALUES ('Camila', 1010);

-- Matrícula de 5 estudantes em cada turma
INSERT INTO turma_estudante (turma_id, estudante_id) VALUES (1, 1);
INSERT INTO turma_estudante (turma_id, estudante_id) VALUES (1, 2);
INSERT INTO turma_estudante (turma_id, estudante_id) VALUES (1, 3);
INSERT INTO turma_estudante (turma_id, estudante_id) VALUES (1, 4);
INSERT INTO turma_estudante (turma_id, estudante_id) VALUES (1, 5);

INSERT INTO turma_estudante (turma_id, estudante_id) VALUES (2, 6);
INSERT INTO turma_estudante (turma_id, estudante_id) VALUES (2, 7);
INSERT INTO turma_estudante (turma_id, estudante_id) VALUES (2, 8);
INSERT INTO turma_estudante (turma_id, estudante_id) VALUES (2, 9);
INSERT INTO turma_estudante (turma_id, estudante_id) VALUES (2, 10);