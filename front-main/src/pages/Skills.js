import React, { useState, useEffect } from "react";
import Card from "react-bootstrap/Card";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Pagination from "react-bootstrap/Pagination";
import axios from "axios";

function SkillCard(props) {
  const { name, level } = props;


  return (
    <Card className="shadow bg-light mb-4 animated bounceIn">
      <Card.Body>
        <Card.Title>{name}</Card.Title>
        <Card.Text>
          <span>Level: {level}</span>
          <div className="progress">
            <div
              className="progress-bar"
              role="progressbar"
              style={{ width: `${level}%`, backgroundColor: "black" }}
              aria-valuenow={level}
              aria-valuemin="0"
              aria-valuemax="10"
            ></div>
          </div>
        </Card.Text>
      </Card.Body>
    </Card>
  );
}

function Skills() {
  const [skillsData, setSkillsData] = useState([]);
  const PAGE_SIZE = 3;
  const [activePage, setActivePage] = useState(1);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios.get("http://localhost:8081/skills")
      .then((response) => {
        setSkillsData(response.data);
      })
      .catch((error) => {
        setError(error);
      });
  }, []);

  if (error) {
    return <div>Error fetching data: {error.message}</div>;
  }

  const totalPages = Math.ceil(skillsData.length / PAGE_SIZE);

  const handleClick = (event) => {
    setActivePage(Number(event.target.text));
  };
  

  const pages = [];

  for (let number = 1; number <= totalPages; number++) {
    pages.push(
      <Pagination.Item
        key={number}
        active={number === activePage}
        onClick={handleClick}
      >
        {number}
      </Pagination.Item>
    );
  }

  const startIndex = (activePage - 1) * PAGE_SIZE;
  const endIndex = activePage * PAGE_SIZE;
  const currentSkills = skillsData.slice(startIndex, endIndex);
  const cardStyle = {
    backgroundColor: "#77b5ae" , // Alternating background colors
    
  };

  return (
    <Card style={cardStyle}>
      <Row className="justify-content-center my-3">
        {currentSkills.map((skill, index) => (
          <Col key={index} xs={12}>
            <SkillCard
              name={skill.name}
              level={skill.level}
            />
          </Col>
        ))}
      </Row>
      <Row className="my-3">
        <Col>
          <Pagination className="justify-content-center">{pages}</Pagination>
        </Col>
      </Row>
    </Card>
  );
}

export default Skills;
