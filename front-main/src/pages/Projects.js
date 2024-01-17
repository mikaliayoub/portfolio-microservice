// Projets.js
import { Card } from "primereact/card";

import React from "react";
import ProjectsCard from "./ProjectsCard";

function Projets() {
  return (
    <Card>
      <section className="section">
        <div>
          <ProjectsCard />
        </div>
      </section>
    </Card>
  );
}

export default Projets;
