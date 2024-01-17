import React, { useState, useEffect } from "react";
import { Card } from "primereact/card";
import { FaCalendarAlt, FaMapMarkerAlt, FaBook } from "react-icons/fa";
import axios from "axios";

const ExperienceCard = ({
  title,
  position,
  duration,
  location,
  courses,
}) => {
  const cardStyle = {
    backgroundColor: "#fff4fb", // Alternating background colors
  };

  const footerTemplate = (
    <div>
      <div className="p-d-flex p-flex-column text-muted">
        <small className="p-mb-2">
          <FaCalendarAlt className="p-mr-1" /> {duration}
        </small>
        {location && (
          <small>
            <FaMapMarkerAlt className="p-mr-1" /> {location}
          </small>
        )}
      </div>
    </div>
  );

  return (
    <Card
      title={title}
      subTitle={position}
      footer={footerTemplate}
      style={cardStyle}
    >
      <div>
        <h5 className="p-mb-2">
          <FaBook className="p-mr-1" /> Cours:
        </h5>
        <ul>
          {courses.map((course, index) => (
            <li key={index}>{course}</li>
          ))}
        </ul>
      </div>
    </Card>
  );
};

const Experiences = () => {
  const [experiences, setExperiences] = useState([]);
  const [skills, setSkills] = useState([]);

  useEffect(() => {
    const fetchExperiences = async () => {
      try {
        const response = await axios.get("http://localhost:8083/experiences");
        setExperiences(response.data);
      } catch (error) {
        console.error("Error fetching experiences:", error);
      }

      try {
        const response = await axios.get("http://localhost:8083/experiences/1/skills");
        setSkills(response.data);
      } catch (error) {
        console.error("Error fetching skills:", error);
      }
    };

    fetchExperiences();
  }, []);

  return (
    <Card className="section">
      <section>
        <div className="experience-grid">
          {experiences.map((experience, index) => (
            <div key={index} className="card">
              <ExperienceCard
                title={experience.title}
                position={experience.position}
                duration={experience.startDate + " to " + experience.endDate}
                location={experience.company}
                courses={skills}
                index={index}
              />
            </div>
          ))}
        </div>
      </section>
    </Card>
  );
};

export default Experiences;
