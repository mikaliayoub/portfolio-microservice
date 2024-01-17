import React, { useState, useEffect } from "react";
import { Card } from "react-bootstrap";
import axios from "axios";

function Formations() {
  const [educations, setEducations] = useState([]);

  useEffect(() => {
    const fetchEducations = async () => {
      try {
        const response = await axios.get("http://localhost:8084/educations");
        setEducations(response.data);
      } catch (error) {
        console.error("Error fetching educations:", error);
      }
    };

    fetchEducations();
  }, []);

  const cardStyle = {
    backgroundColor: "#77b5ae", // Alternating background colors
  };

  return (
    <Card style={cardStyle}>
      <section className="section">
        {educations.map((education) => (
          <Card key={education.id} className="mb-3">
            <Card.Body>
              <Card.Title>{education.degree}</Card.Title>
              <Card.Subtitle className="mb-2 text-muted">
                {education.institution}
              </Card.Subtitle>
              <Card.Text>{education.graduationYear}</Card.Text>
            </Card.Body>
          </Card>
        ))}
      </section>
    </Card>
  );
}

export default Formations;
