import React, { useState, useEffect } from 'react';
import Card from 'react-bootstrap/Card';
import axios from 'axios';

const ProjectCard = () => {
  const [projects, setProjects] = useState([]);

  useEffect(() => {
    const fetchProjects = async () => {
      try {
        const response = await axios.get('http://localhost:8082/projects');
        setProjects(response.data);
      } catch (error) {
        console.error('Error fetching projects:', error);
      }
    };

    fetchProjects();
  }, []);

  return (
    <div className="project-container">
      {projects.map((project, index) => (
        <Card key={index} className="project-card">
          <Card.Body>
            <Card.Title className="project-title">{project.title}</Card.Title>
            <Card.Text className="project-description">{project.description}</Card.Text>
            <Card.Text className="project-skills"><p1><strong>Technologies:</strong></p1><br />{project.skills.join(', ')}</Card.Text>
            <Card.Link href={`https://github.com/BalckTulib`} className="project-link">
              Voir les compétences
            </Card.Link>
          </Card.Body>
        </Card>
      ))}
    </div>
  );
};

export default ProjectCard;
